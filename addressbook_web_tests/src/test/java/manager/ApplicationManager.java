package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;


public class ApplicationManager {
    public WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;



    private Properties properties;


    public void init(String browser, Properties properties) throws MalformedURLException {
        this.properties = properties;
        System.setProperty("webdriver.chrome.driver", "C:\\Chrome\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Firefox\\geckodriver.exe");

        if (driver == null) {
            var seleniumServer = properties.getProperty("seleniumServer");
            if ("firefox".equals(browser)) {
                if (seleniumServer != null) {
                    driver= new RemoteWebDriver(new URL(seleniumServer), new FirefoxOptions());
                } else {
                    driver = new FirefoxDriver();
                }
            } else if ("chrome".equals(browser)) {
                if (seleniumServer != null) {
                    driver= new RemoteWebDriver(new URL(seleniumServer), new ChromeOptions());
                } else {
                    driver = new ChromeDriver();
                }
            }
        } else {
            throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
        }
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
        driver.get(properties.getProperty("web.baseUrl"));
        driver.manage().window().setSize(new Dimension(550, 693));
        session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return session;
    }

    public GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return groups;

    }


    public ContactHelper contacts() {
        if (contacts == null) {
            contacts = new ContactHelper(this);
        }
        return contacts;

    }
    public JdbcHelper jdbc() {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        return jdbc;

    }

    public HibernateHelper hbm() {
        if (hbm == null) {
            hbm = new HibernateHelper(this);
        }
        return hbm;

    }


    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}

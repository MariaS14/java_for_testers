package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;


public class ApplicationManager {
    public WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private ContactHelper contacts;
    private JdbcHelper jdbc;
    private HibernateHelper hbm;



    private Properties properties;


    public void init(String browser, Properties properties) {
        this.properties = properties;
        if (driver == null) {

            if ("firefox".equals(browser)) {
                var service = new GeckoDriverService.Builder();
                service.usingDriverExecutable(new File("C:/windows/system32/geckodriver.exe"));
                service.build();
                driver = new FirefoxDriver(service.build());

            } else if ("chrome".equals(browser)) {
                var service = createDefaultService();
                service.setExecutable("c:/windows/system32/chromedriver.exe");
                driver = new ChromeDriver(service);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            //var service = ChromeDriverService.createDefaultService();
            //service.setExecutable("c:/windows/system32/chromedriver.exe");
            //driver = new ChromeDriver(service);
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(809, 1020));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));

        }
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

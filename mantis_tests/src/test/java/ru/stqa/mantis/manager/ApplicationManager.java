package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;

public class ApplicationManager {

    public WebDriver driver;

    private String string;
    private String browser;
    private Properties properties;
    private SessionHelper sessionHelper;
    private HttpSessionHelper httpSessionHelper;
    private JamesCliHelper jamesCliHelper;

    private RegistrationHelper registrationHelper;
    private MailHelper mailHelper;
    private JamesApiHelper jamesApiHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;

    }


    public WebDriver driver() {
        if (driver == null) {
            if ("firefox".equals(browser)) {
                var service = new GeckoDriverService.Builder();
                service.usingDriverExecutable(new File("C:/windows/system32/geckodriver.exe"));
                service.build();
                driver = new FirefoxDriver(service.build());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            } else if ("chrome".equals(browser)) {
                var service = createDefaultService();
                service.setExecutable("c:/windows/system32/chromedriver.exe");
                driver = new ChromeDriver(service);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(809, 1020));

        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public HttpSessionHelper http() {
        if (httpSessionHelper == null) {
            httpSessionHelper = new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }

    public JamesCliHelper jamesCli() {
        if (jamesCliHelper == null) {
            jamesCliHelper = new JamesCliHelper(this);
        }
        return jamesCliHelper;
    }

    public JamesApiHelper jamesApiHelper() {
        if (jamesApiHelper == null) {
            jamesApiHelper = new JamesApiHelper(this);
        }
        return jamesApiHelper;
    }

    public MailHelper mail() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }
    public String property(String name){
        return properties.getProperty(name);
    }
}





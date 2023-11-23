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

    private String string;
    private Properties properties;
    private SessionHelper sessionHelper;
    private HttpSessionHelper httpSessionHelper;
    private JamesCliHelper jamesCliHelper;
    private MailHelper mailHelper;
    private RegistrationHelper registrationHelper;
    private JamesApiHelper jamesApiHelper;
    //private LoginHelper loginSession;
    private DeveloperMailHelper developerMailHelper;
    //private RestApiHelper restApiHelper;


    private WebDriver driver;



    public void init(String browser, Properties properties) {
        this.properties = properties;
        this.string = browser;
    }




    public WebDriver driver(){
        if(driver==null){
            if ("firefox".equals(string)) {
                var service = new GeckoDriverService.Builder();
                service.usingDriverExecutable(new File("C:/windows/system32/geckodriver.exe"));
                service.build();
                driver = new FirefoxDriver(service.build());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            } else if ("chrome".equals(string)) {
                var service = createDefaultService();
                service.setExecutable("c:/windows/system32/chromedriver.exe");
                driver = new ChromeDriver(service);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", string));
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
public JamesApiHelper jamesApi() {
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

   /*public UserHelper user(){
        if (userHelper == null) {
            userHelper = new UserHelper(this);
        }
        return userHelper;
    }*/
    /*  public RestApiHelper rest() {
       if (restApiHelper == null) {
           restApiHelper = new RestApiHelper(this);
       }
       return restApiHelper;*/
    public DeveloperMailHelper developerMail(){
        if (developerMailHelper == null) {
            developerMailHelper = new DeveloperMailHelper(this);
        }
        return developerMailHelper;
    }
    public String property(String name){
        return properties.getProperty(name);
    }


}





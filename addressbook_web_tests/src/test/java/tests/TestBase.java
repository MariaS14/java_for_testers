package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class TestBase {

    protected static ApplicationManager app;
    protected static WebDriver driver;

    @BeforeEach
    public void setUp() {

        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser","firefox"));
        }
    }
}

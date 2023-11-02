package tests;

import model.ContactData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class ContactCreationTests extends TestBase {

    /*@BeforeEach
    public void setUp() {
        if (driver == null) {
            var service = new GeckoDriverService.Builder();
            service.usingDriverExecutable(new File("C:/windows/system32/geckodriver.exe"));
            service.build();
            driver = new FirefoxDriver(service.build());
        }
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1184, 784));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }*/

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }

    /*@Test
    public void CanCreateContact() {
    app.contacts().createContact(new ContactData("contact name", "contact name", "contact phone"));
    }*/


    @Test

    public void canCreateContact() {

        if (!isElementPresent(By.id("1"))) {
            driver.findElement(By.linkText("home")).click();
        }
        driver.findElement(By.linkText("add new")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).click();

        {
            WebElement element = driver.findElement(By.name("firstname"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys("contact name");
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys("contact name");
        driver.findElement(By.name("middlename")).click();
        driver.findElement(By.name("middlename")).sendKeys("contact name");
        driver.findElement(By.name("home")).sendKeys("contact phone");


        driver.findElement(By.cssSelector("input:nth-child(87)")).click();
        driver.findElement(By.linkText("home page")).click();
    }

    /*protected boolean isElementPresent(By locator) {

        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }*/
}




package tests;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.interactions.Actions;
import tests.TestBase;
import model.ContactData;



import java.io.File;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.chrome.ChromeDriverService.createDefaultService;

public class ContactRemovalTests extends TestBase {
    /*private static WebDriver driver;

    @BeforeEach
    public void setUp() {

        if (driver == null) {
            var service = createDefaultService();
            service.setExecutable("c:/windows/system32/chromedriver.exe");
            driver = new ChromeDriver(service);
        }
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1184, 784));
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("pass")).sendKeys("secret");
        driver.findElement(By.xpath("//input[@value=\'Login\']")).click();

    }

    @AfterEach
    public void tearDown() {
        driver.findElement(By.linkText("Logout")).click();
        driver.quit();
    }*/

    @Test

    public void canRemoveContact() {
        app.driver.findElement(By.linkText("home")).click();
        if (!app.isElementPresent(By.cssSelector("#maintable input[type='checkbox']:first-child"))) {
            app. driver.findElement(By.linkText("add new")).click();
            {
                WebElement element = app.driver.findElement(By.name("firstname"));
                Actions builder = new Actions(app.driver);
                builder.doubleClick(element).perform();
            }
            app.driver.findElement(By.name("firstname")).click();
            app.driver.findElement(By.name("firstname")).sendKeys("contact name");
            app.driver.findElement(By.name("lastname")).click();
            app.driver.findElement(By.name("lastname")).sendKeys("contact name");
            app.driver.findElement(By.name("middlename")).click();
            app.driver.findElement(By.name("middlename")).sendKeys("contact name");
            app.driver.findElement(By.name("home")).sendKeys("contact phone");
            app.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
            app.driver.findElement(By.linkText("home page")).click();

        }

        app.driver.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child")).click();
        app.driver.findElement(By.cssSelector("input[value='Delete']")).click();
        MatcherAssert.assertThat(app.driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
        app.driver.switchTo().alert().accept();

    }


    //driver.findElement(By.id("1")).click();
    //driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
    //MatcherAssert.assertThat(driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
    //driver.switchTo().alert().accept();
    //}



  /*private boolean isElementPresent(By id) {


  driver.findElement(By.id("1")).click();
  driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
  MatcherAssert.assertThat(driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
  driver.switchTo().alert().accept();
  return false;
   }
  }*/


}


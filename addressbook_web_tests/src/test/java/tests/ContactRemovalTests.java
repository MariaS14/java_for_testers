package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ContactRemovalTests extends TestBase {

    @Test

    public void canRemoveContact() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("contact name", "contact lastname", "contact phone"));
        }
        app.contacts().removeContact();

    }


    //app.driver.findElement(By.linkText("home")).click();

            /*app. driver.findElement(By.linkText("add new")).click();
            {
                WebElement element = app.driver.findElement(By.name("firstname"));
                Actions builder = new Actions(app.driver);
                builder.doubleClick(element).perform();
            }
            app.driver.findElement(By.linkText("add new")).click();
            app.driver.findElement(By.name("firstname")).click();
            app.driver.findElement(By.name("firstname")).sendKeys();
            app.driver.findElement(By.name("lastname")).click();
            app.driver.findElement(By.name("lastname")).sendKeys();
            app.driver.findElement(By.name("mobile")).click();
            app.driver.findElement(By.name("mobile")).sendKeys();
            app.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
            app.driver.findElement(By.linkText("home")).click();*/
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


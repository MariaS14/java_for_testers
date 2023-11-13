package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ContactRemovalTests extends TestBase {

    @Test

    public void canRemoveContact() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount()==0){
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone",""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }




    @Test
    void canRemoveAllContactsAtOnce() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount()==0){
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone",""));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.hbm().getContactCount());


    }
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
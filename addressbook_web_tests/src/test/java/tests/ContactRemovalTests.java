package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;



public class ContactRemovalTests extends TestBase {

    @Test

    public void canRemoveContact() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone"));
        }
        /*int contactCount = app.contacts().getCountContact();
        var oldContacts = app.contacts().getListContacts();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContacts(oldContacts.get(index));
        var newContacts = app.contacts().getListContacts();
        //int newContactCount = app.contacts().getCountContact();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts,expectedList);

    }*/
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.contacts().getCountContact() == 0) {
            app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone"));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCountContact());


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





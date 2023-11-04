package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ContactCreationTests extends TestBase {

    @Test

    public void canCreateContact() {

        app.contacts().createContact(new ContactData("contact name", "contact lastname", "contact phone"));
    }


    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());


    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData().withName("some name"));


    }
}


//app.driver.findElement(By.linkText("home")).click();
//if (!app.isElementPresent(By.cssSelector("#maintable input[type='checkbox']:first-child"))) {
        /*if (!isElementPresent(By.id("1"))) {
            app.driver.findElement(By.linkText("home")).click();
        }
        app.driver.findElement(By.linkText("add new")).click();
        app.driver.findElement(By.name("firstname")).click();*/


        /*{
            WebElement element = app.driver.findElement(By.name("firstname"));
            Actions builder = new Actions(app.driver);
            builder.doubleClick(element).perform();
        }*/





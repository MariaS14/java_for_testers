package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var name : List.of("", "contact name")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var phone : List.of("", "contact phone")) {
                    result.add(new ContactData(name, lastname, phone));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }



    @Test

    public void canCreateContact() {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(new ContactData("contact name", "contact lastname", "contact phone"));
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount+1,newContactCount);
    }


    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());


    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData().withName("some name"));


    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);

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





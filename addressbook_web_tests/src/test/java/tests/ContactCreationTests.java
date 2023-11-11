package tests;

import model.ContactData;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact name")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var phone : List.of("", "9273471")) {
                    for (var photo : List.of("src/test/resources/images/avatar.png")) {
                        result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withPhone(phone).withPhoto(photo));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withPhone(randomString(i * 10))
                    .withPhoto(randomString(i * 10)));
        }
        return result;
    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {

        var oldContacts = app.contacts().getListContacts();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContacts();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withFirstName(contact.firstname()).withLastName(contact.lastname()).withPhone(contact.phone()).withPhoto(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }


    @Test
    public void CreateContact() {
        var contact = new ContactData()
                .withFirstName(randomString(10))
                .withLastName(randomString(10))
                .withPhone(randomString(10))
                .withPhoto("src/test/resources/images/avatar.png");
        app.contacts().createContact(contact);
    }


    @Test

    public void canCreateContact() {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", "src/test/resources/images/avatar.png"));
        //app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone",""));
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }


    @Test
    public void canCreateContactWithEmptyName() {
        app.contacts().createContact(new ContactData());


    }

    @Test
    public void canCreateContactWithNameOnly() {
        app.contacts().createContact(new ContactData().withFirstName("some name"));


    }


    public static @NotNull List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("", "contact name'", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void canNotCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.contacts().getListContacts();

        //int contactCount = app.groups().getCount();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContacts();
        Assertions.assertEquals(newContacts, oldContacts);

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

/* int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);*/
/*правильный код создания
public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "contact name")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var phone : List.of("", "9273471")) {
                    result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withPhone(phone));
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData().withFirstName(randomString(i * 10))
                    .withLastName(randomString(i * 10))
                    .withPhone(randomString(i * 10)));
                    //.withPhoto("src/test/resources/images/avatar.png"));

        }
        return result;

    }
    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {

        var oldContacts = app.contacts().getListContacts();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getListContacts();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size()-1).id()).withFirstName(contact.firstname()).withLastName(contact.lastname()).withPhone(contact.phone()));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);

    }
 */


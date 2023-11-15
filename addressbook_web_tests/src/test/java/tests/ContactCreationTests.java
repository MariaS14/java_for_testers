package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.ContactData;
import model.GroupData;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import ru.stqa.addressbook.common.CommonFunctions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() throws IOException {
        var result = new ArrayList<ContactData>();
        /*for (var firstname : List.of("", "contact name")) {
            for (var lastname : List.of("", "contact lastname")) {
                for (var phone : List.of("", "9273471")) {
                    for (var photo : List.of("src/test/resources/images/avatar.png")) {
                        result.add(new ContactData().withFirstName(firstname).withLastName(lastname).withPhone(phone).withPhoto(photo));
                    }
                }
            }
        }
        var json = "";
        try(var reader = new FileReader("contacts.json");
            var breader = new BufferedReader(reader)
        ) {
            var line = breader.readLine();
            while (line != null) {
                json =json + line;
                line = breader.readLine();
            }
        }*/
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>() {
        });

        result.addAll(value);//добавили в рамках этого исключение в метод throws IOException
        return result;
        /*for (int i = 0; i < 5; i++) {
            result.add(new ContactData()
                    .withFirstName(CommonFunctions.randomString(i * 10))
                    .withLastName(CommonFunctions.randomString(i * 10))
                    .withPhone(CommonFunctions.randomString(i * 10))
                    .withPhoto(randomFile("src/test/resources/images")));
        }*/

    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {

        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
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
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhone(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        app.contacts().createContact(contact);
    }

    @Test
    public void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhone(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());//в дз тут сравнить не только размер, но и содержимое списков тоже
    }

    @Test
    public void canAddContactInGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));
        }
       var contact = new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhone(CommonFunctions.randomString(10))
                .withPhoto(randomFile("src/test/resources/images"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().addContactInGroup(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
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


  /*  @Test
    public void ContactAddToGroup(ContactData contact) {
        app.driver.get("http://localhost/addressbook/");

        app.driver.findElement(By.name("1543")).click();
        app.driver.findElement(By.name("to_group")).click();
        {
            WebElement dropdown = app.driver.findElement(By.name("to_group"));
            dropdown.findElement(By.xpath("//option[. = 'wefwe']")).click();
        }
        app.driver.findElement(By.name("add")).click();
        //app.driver.findElement(By.linkText("group page \"wefwe\"")).click();


        //app.driver.manage().window().setSize(new Dimension(1184, 784));
        //app.driver.findElement(By.name("user")).sendKeys("admin");
        //app.driver.findElement(By.name("pass")).sendKeys("secret");
        app.contacts().addContactInGroup(oldContacts.get(index), testData);
        app.driver.findElement(By.cssSelector("input:nth-child(7)")).click();
        app.driver.findElement(By.id("1543")).click();
        app.driver.findElement(By.name("to_group")).click();
        {
            WebElement dropdown = app.driver.findElement(By.name("to_group"));
            dropdown.findElement(By.xpath("//option[. = 'wefwe']")).click();
        }
        app.driver.findElement(By.name("add")).click();
        app.driver.findElement(By.linkText("group page \"wefwe\"")).click();
    }
    }
}*/


//app.driver.findElement(By.linkText("home")).click();
//if (!app.isElementPresent(By.cssSelector("#maintable input[type='checkbox']:first-child"))) {
        /*if (!isElementPresent(By.id("1"))) {
            app.driver.findElement(By.linkText("home")).click();
        }
        app.driver.findElement(By.linkText("add new")).click();
        app.driver.findElement(By.name("firstname")).click();*/


        /*{

         @Test
  public void tes2() {
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1184, 784));
    driver.findElement(By.linkText("home")).click();
    driver.findElement(By.name("group")).click();
    {
      WebElement dropdown = driver.findElement(By.name("group"));
      dropdown.findElement(By.xpath("//option[. = 'wefwe']")).click();
    }
    driver.findElement(By.id("1543")).click();
    driver.findElement(By.name("remove")).click();
    driver.findElement(By.linkText("group page \"wefwe\"")).click();
  }
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
                    .withFirstName(CommonFunctions.randomString(i * 10))
                    .withLastName(CommonFunctions.randomString(i * 10))
                    .withPhone(CommonFunctions.randomString(i * 10))
                    .withPhoto(randomFile("src/test/resources/images")));
        }
        return result;
    }
 */

   /*@Test

    public void canCreateContact() {
        int contactCount = app.contacts().getCountContact();
        app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", "src/test/resources/images/avatar.png"));
        //app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone",""));
        int newContactCount = app.contacts().getCountContact();
        Assertions.assertEquals(contactCount + 1, newContactCount);

    }*/
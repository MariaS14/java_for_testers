package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhonesEmailsAdresses() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone("604943")
                    .withPhoto(randomFile("src/test/resources/images"))
                    .withHome("3234")
                    .withWork("555555")
                    .withSecondary("22342")
                    .withAddress("Address")
                    .withAddress2("Address2")
                    .withEmail("email")
                    .withEmail2("email2")
                    .withEmail3("email3"));
        }
        var contacts = app.hbm().getContactList();
        var expected = contacts.stream().collect(Collectors.toMap(ContactData::id, contact ->
                Stream.of(contact.home(), contact.phone(), contact.work(), contact.secondary())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"))
        ));
        var phones = app.contacts().getPhones();
        Assertions.assertEquals(expected, phones);

        var contact = contacts.get(0);
        var emails = app.contacts().getEmail(contact);
        var expected1 = Stream.of(contact.email(), contact.email2(), contact.email3())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected1, emails);


        var addresses = app.contacts().getAddress(contact);
        var expected2 = Stream.of(contact.address(), contact.address2())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected2, addresses);
    }
}





        /*var phones = app.contacts().getPhones(contact);
        expected = Stream.of(contact.home(), contact.mobile(), contact.work())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);*/








    /*@Test
    void testAddress() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone("604943")
                    .withPhoto(randomFile("src/test/resources/images"))
                    .withHome("3234")
                    .withWork("555555")
                    .withSecondary("22342")
                    .withAddress("Address")
                    .withAddress2("Address2")
                    .withEmail("email")
                    .withEmail2("email2")
                    .withEmail3("email3"));
        }
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var addresses = app.contacts().getAddress(contact);
        var expected = Stream.of(contact.address(), contact.address2())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, addresses);
    }


 /*   @Test
    void testPhones() {
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var expected = Stream.of(contact.home(), contact.phone(), contact.work(), contact.secondary())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }//тест только для одного первого попавшегося контакта*/


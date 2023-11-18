package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones() {
        var contacts = app.hbm().getContactList();
        var phones = app.contacts().getPhones();
        for (var contact: contacts) {
            var expected = Stream.of(contact.home(), contact.phone(), contact.work(), contact.secondary())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"));
            Assertions.assertEquals(expected, phones.get(contact.id()));

        }
    }

    @Test
    void testEmail() {
        var contacts = app.hbm().getContactList();
        for (var contact : contacts) {
            var emails = app.contacts().getEmail(contact);
            var expected = Stream.of(contact.email(), contact.email2(), contact.email3())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"));
            Assertions.assertEquals(expected, emails);
        }
    }

    @Test
    void testAddress() {
        var contacts = app.hbm().getContactList();
        for (var contact : contacts) {
            var addresses = app.contacts().getAddress(contact);
            var expected = Stream.of(contact.address(), contact.address2())
                    .filter(s -> s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"));
            Assertions.assertEquals(expected, addresses);
        }
    }
}



/* @Test
    void testPhones (){
        var contacts = app.hbm().getContactList();
        var contact = contacts.get(0);
        var phones = app.contacts().getPhones(contact);
        var expected = Stream.of(contact.home(), contact.phone(), contact.work(), contact.secondary())
                .filter(s->s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expected, phones);
    }//тест только для одного первого попавшегося контакта
}*/

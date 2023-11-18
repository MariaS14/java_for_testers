package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    @Test
    void testPhones (){
        var contacts = app.hbm().getContactList();
        for (var contact: contacts){
            var phones = app.contacts().getPhones(contact);
            var expected = Stream.of(contact.home(), contact.phone(), contact.work(), contact.secondary())
                    .filter(s->s != null && !"".equals(s))
                    .collect(Collectors.joining("\n"));
            Assertions.assertEquals(expected, phones);

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

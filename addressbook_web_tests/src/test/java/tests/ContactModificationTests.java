package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase{

    @Test

    void canModifyContact(){
        if (app.contacts().getCountContact()==0){
            app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone"));
        }
        /*app.contacts().modifyContact(new ContactData().withName("modified name"));*/
        var oldContacts = app.contacts().getListContacts();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.contacts().getListContacts();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }
}

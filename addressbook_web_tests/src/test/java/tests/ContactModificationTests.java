package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase{

    @Test

    void canModifyContact(){
        if (app.hbm().getContactCount()==0){
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone",""));
        }
        /*app.contacts().modifyContact(new ContactData().withName("modified name"));*/
        var oldContacts = app.hbm(). getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = new ContactData().withFirstName("modified name");
        app.contacts().modifyContact(oldContacts.get(index), testData);
        var newContacts = app.hbm(). getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.set(index, testData.withId(oldContacts.get(index).id()));
        //expectedList.set(index, testData.withId(newContacts.get(newContacts.size()-1).id()).withFirstName(firstname()).withLastName(contact.lastname()).withPhone(contact.phone()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts,expectedList);
    }
}





    /*  @ParameterizedTest
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
*

    /*
    void canModifyContact(){
        if (app.contacts().getCountContact()==0){
            app.contacts().createContact(new ContactData("", "contact name", "contact lastname", "contact phone"));
        }
        /*app.contacts().modifyContact(new ContactData().withName("modified name"));было*/
        /*var oldContacts = app.contacts().getListContacts();
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


}*/
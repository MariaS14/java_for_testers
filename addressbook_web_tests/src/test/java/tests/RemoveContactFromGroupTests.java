package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.*;

public class RemoveContactFromGroupTests extends TestBase {







    public static List<ContactData> RandomContact() {
        return List.of(new ContactData()
                .withFirstName(CommonFunctions.randomString(10))
                .withLastName(CommonFunctions.randomString(10))
                .withPhone(CommonFunctions.randomString(10)));
        //.withPhoto(randomFile("src/test/resources/images")));
    }

    @ParameterizedTest
    @MethodSource("RandomContact")
    void canContactRemoveFromGroup(ContactData contact) {

        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var groupList = app.hbm().getGroupList();

        ContactData contactRemoveFromGroup = null;
        GroupData groupData = null;
        for (int i = 0; i < groupList.size() - 1; i++) {
            var contactListInGroup = app.hbm().getContactsInGroup(groupList.get(i));
            if  ( (contactListInGroup != null) && (!contactListInGroup.isEmpty()) ) {
                contactRemoveFromGroup = contactListInGroup.get(0); //В группе нашелся контакт
                groupData = groupList.get(i);
                break;
            }
        }

        if (contactRemoveFromGroup == null) {
            var contactListNotInGroup = app.hbm().getContactsNotInGroup();
            if  ( (contactListNotInGroup != null) && (!contactListNotInGroup.isEmpty()) ) {
                contactRemoveFromGroup = contactListNotInGroup.get(0); // В полученном с БД списке найден контакт без группы
                groupData = groupList.get(0);
                app.contacts().addContactInGroup(contactRemoveFromGroup, groupData); // Контакт добавляется в группу
            }
        }
        if (contactRemoveFromGroup == null) {
            app.contacts().createContact(contact);
            contact = contact.withId(app.hbm().getIdContactByName(contact.firstname()));
            groupData = groupList.get(0);
            app.contacts().addContactInGroup(contact, groupData);
            contactRemoveFromGroup = contact;
        }
        var oldContacts = app.hbm().getContactsInGroup(groupData);
        app.contacts().selectFromListGroup(groupData);
        app.contacts().removeContactFromGroup(contactRemoveFromGroup, groupData);
        var newContacts = app.hbm().getContactsInGroup(groupData);
        var expectedList = new ArrayList<>(oldContacts);
        ContactData newRelated = contactRemoveFromGroup;
        expectedList.removeIf(contactData -> newRelated.id().equals(contactData.id()));
        Assertions.assertEquals(Set.copyOf(expectedList), Set.copyOf(newContacts));
    }


}

    /*@Test
    public void canRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", "","","","","","","","",""));
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        boolean contactAlreadyInGroup = oldRelated.contains(testData);

        if (contactAlreadyInGroup) {
            app.contacts().removeContactFromGroup(testData, group);//удаляяем контакт из группы
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            var expectedList = new ArrayList<>(oldRelated);
            expectedList.removeIf(c -> c.id().equals(testData.id()));
            expectedList.sort(compareById);
            Assertions.assertEquals(newRelated, expectedList);



        } else {
            app.contacts().addContactInGroup(testData, group);//добавление контакта в группу
            app.contacts().removeContactFromGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size(), newRelated.size());
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            var expectedList = new ArrayList<>(oldRelated);
            expectedList.removeIf(c -> c.id().equals(testData.id()));
            expectedList.sort(compareById);
            Assertions.assertEquals(newRelated, expectedList);


        }
    }
}*/



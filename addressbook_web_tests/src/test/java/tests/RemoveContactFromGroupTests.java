package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class RemoveContactFromGroupTests extends TestBase {
    @Test
    public void canRemoveContactFromGroup() {
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));
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
            newRelated.sort(compareById);
            expectedList.sort(compareById);
        } else {
            app.contacts().addContactInGroup(testData, group);//добавление контакта в группу
            app.contacts().removeContactFromGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size() , newRelated.size());
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            var expectedList = new ArrayList<>(oldRelated);
            newRelated.sort(compareById);
            expectedList.sort(compareById);

        }

        //app.contacts().openContactsPage(By.linkText("home"));
        //var newRelatedAfterRemove = app.hbm().getContactsInGroup(group);//удаление контата из нового списка
        //Assertions.assertEquals(newRelated.size() - 1, newRelatedAfterRemove.size());

    }
}



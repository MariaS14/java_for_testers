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
import java.util.Set;

public class AddContactInGroupTests extends TestBase {
    @Test
    public void canAddContactInGroup() {

        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", "", "", "", "", "", "", "", "", ""));//проверка есть ли контакт- если нет создание
        }
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));//проверка есть ли группа- если нет создаем
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());//Генерируем случайный индекс в пределах размера списка oldContacts.
        var testData = oldContacts.get(index);//Получаем случайный контакт из списка oldContacts с использованием сгенерированного индекса.
        var group = app.hbm().getGroupList().get(0);//получаем список групп и выбираем 1ю из них group = oldGroups.Выбрана группа, именно в нее будет включен созданный контакт
        //проверка какие контакты были включены в эту группу до тестирования
        var oldRelated = app.hbm().getContactsInGroup(group);//получили список контактов, которые входят в заданную группу
        boolean contactAlreadyInGroup = oldRelated.contains(testData);

        if (!contactAlreadyInGroup) {
            var contact = testData;
            app.contacts().addContactInGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            var expectedList = new ArrayList<>(oldRelated);
            expectedList.add(contact.withId(newRelated.get(newRelated.size() - 1).id()).withFirstName(contact.firstname()).withLastName(contact.lastname()).withPhone(contact.phone()).withPhoto(""));
            expectedList.sort(compareById);
            Assertions.assertEquals(newRelated, expectedList);

        } else {
            //иначе создаем новый контакт и добавляем в группу
            var contact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            app.contacts().createContact(contact, group);//операция создания
            app.contacts().addContactInGroup(testData, group);//добавили контакт в группу
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size()+1, newRelated.size());
            Comparator<ContactData> compareById = (o1, o2) -> {
                return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
            };
            newRelated.sort(compareById);
            var expectedList = new ArrayList<>(oldContacts);
            expectedList.add(contact.withId(newRelated.get(newRelated.size() - 1).id()).withFirstName(contact.firstname()).withLastName(contact.lastname()).withPhone(contact.phone()).withPhoto(""));
            expectedList.sort(compareById);
            Assertions.assertEquals(newRelated, expectedList);
        }

    }
}
        /*

        //var expectedList = new ArrayList<>(oldRelated);
            //newRelated.sort(compareById);
            //expectedList.sort(compareById);
            //Assertions.assertEquals(newRelated, expectedList);app.contacts().addContactInGroup(testData, group);//добавили контакт в группу
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var expectedList = new ArrayList<>(oldRelated);
        newRelated.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newRelated, expectedList);*/




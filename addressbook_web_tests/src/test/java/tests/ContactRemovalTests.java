package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import ru.stqa.addressbook.common.CommonFunctions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class ContactRemovalTests extends TestBase {

    @Test


    public void canRemoveContact() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        app.contacts().openContactsPage(By.linkText("home"));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts, expectedList);

    }


    @Test
    void canRemoveAllContactsAtOnce() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));
        }
        app.contacts().removeAllContacts();
        Assertions.assertEquals(0, app.contacts().getCountContact());


    }

    @Test
    public void canRemoveContactFromGroup() {

        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));//проверка есть ли контакт- если нет создание
        if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));//проверка есть ли группа- если нет создаем
            }
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
            var contact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            app.contacts().createContact(contact, group);//операция создания если контакт не в группе

        } else {
            //иначе создаем новый контакт и добавляем в группу
            app.contacts().removeContactFromGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            //Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        }
        app.contacts().removeContactFromGroup(testData, group);//добавили контакт в группу
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var expectedList = new ArrayList<>(oldRelated);
        newRelated.sort(compareById);
        expectedList.sort(compareById);
    }
}



    /* app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));
            if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
            }
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testData = oldContacts.get(index);
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        boolean contactAlreadyInGroup = oldRelated.contains(testData);

        if (!contactAlreadyInGroup) {
            var contact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            if (app.hbm().getGroupCount() == 0) {//если никакой группы нет - создаем
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
            }
            app.contacts().createContact(contact, group);
            var newRelated = app.hbm().getContactsInGroup(group);


        } else {
            app.contacts().removeContactFromGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        }
        app.contacts().removeContactFromGroup(testData, group);//удаляем контакт в группу
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var expectedList = new ArrayList<>(oldRelated);
        newRelated.sort(compareById);
        expectedList.sort(compareById);
    }

    /*@Test
    public void canRemoveContactFromGroup() {
        app.contacts().openContactsPage(By.linkText("home"));
        if (app.hbm().getContactCount() == 0) {
            app.hbm().createContact(new ContactData("", "contact name", "contact lastname", "contact phone", ""));//проверка есть ли контакт- если нет создание
            if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));//проверка есть ли группа- если нет создаем
            }
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());//Генерируем случайный индекс в пределах размера списка oldContacts.
        var testData = oldContacts.get(index);//Получаем случайный контакт из списка oldContacts с использованием сгенерированного индекса.
        var group = app.hbm().getGroupList().get(0);//получаем список групп и выбираем 1ю из них group = oldGroups.Выбрана группа, именно в нее будет включен созданный контакт
        //проверка какие контакты были включены в эту группу до тестирования
        var oldRelated = app.hbm().getContactsInGroup(group);//получили список контактов, которые входят в заданную группу
        boolean contactAlreadyInGroup = oldRelated.contains(testData);

        if (!contactAlreadyInGroup) {// если контакт не в группе,создаем контакт в группе
            var contact = new ContactData()
                    .withFirstName(CommonFunctions.randomString(10))
                    .withLastName(CommonFunctions.randomString(10))
                    .withPhone(CommonFunctions.randomString(10))
                    .withPhoto(randomFile("src/test/resources/images"));
            if (app.hbm().getGroupCount() == 0) {//если никакой группы нет - создаем
                app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
            }
            //проверка какие контакты были включены в эту группу до тестировани
            app.contacts().createContact(contact, group);//операция создания
            var newRelated = app.hbm().getContactsInGroup(group);//получили новый список

        } else {
            //иначе создаем нровый контакт и добавляем в группу
            app.contacts().removeContactFromGroup(testData, group);
            var newRelated = app.hbm().getContactsInGroup(group);
            Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        }
        app.contacts().removeContactFromGroup(testData, group);//добавили контакт в группу
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        var expectedList = new ArrayList<>(oldRelated);
        newRelated.sort(compareById);
        expectedList.sort(compareById);
    }
        /*app.driver.get("http://localhost/addressbook/");
        app.driver.manage().window().setSize(new Dimension(1184, 784));
        app.driver.findElement(By.linkText("home")).click();
        app.driver.findElement(By.name("group")).click();
        {
            WebElement dropdown = app.driver.findElement(By.name("group"));
            dropdown.findElement(By.xpath("//option[. = 'wefwe']")).click();
        }
        app.driver.findElement(By.id("1543")).click();
        app.driver.findElement(By.name("remove")).click();
        app.driver.findElement(By.linkText("group page \"wefwe\"")).click();*/




//app.driver.findElement(By.linkText("home")).click();

            /*app. driver.findElement(By.linkText("add new")).click();
            {
                WebElement element = app.driver.findElement(By.name("firstname"));
                Actions builder = new Actions(app.driver);
                builder.doubleClick(element).perform();
            }
            app.driver.findElement(By.linkText("add new")).click();
            app.driver.findElement(By.name("firstname")).click();
            app.driver.findElement(By.name("firstname")).sendKeys();
            app.driver.findElement(By.name("lastname")).click();
            app.driver.findElement(By.name("lastname")).sendKeys();
            app.driver.findElement(By.name("mobile")).click();
            app.driver.findElement(By.name("mobile")).sendKeys();
            app.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
            app.driver.findElement(By.linkText("home")).click();*/
//driver.findElement(By.id("1")).click();
//driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
//MatcherAssert.assertThat(driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
//driver.switchTo().alert().accept();
//}

  /*private boolean isElementPresent(By id) {
  driver.findElement(By.id("1")).click();
  driver.findElement(By.cssSelector(".left:nth-child(8) > input")).click();
  MatcherAssert.assertThat(driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
  driver.switchTo().alert().accept();
  return false;
   }
  }*/




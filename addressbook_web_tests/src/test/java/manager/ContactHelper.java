package manager;

import java.util.HashMap;
import java.util.List;

import model.ContactData;


import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Map;


public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {

        super(manager);
    }

    private void initContactCreation() {
        manager.driver.findElement(By.linkText("add new")).click();
    }

    public void openContactsPage(By home) {
        manager.driver.findElement(home).click();
    }


    public void createContact(ContactData contact) {
        openContactsPage(By.linkText("home"));
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToContactsPage();
    }

    public void createContact(ContactData contact, GroupData group) {//метод принимает на вход контакт и группу
        openContactsPage(By.linkText("home"));
        initContactCreation();
        fillContactForm(contact);// после заполнения формы контакта - метод должен выбрать группу из выпадающего списка
        selectGroup(group);
        submitContactCreation();
        returnToContactsPage();
    }

    private void selectGroup(GroupData group) { //находит на странице нужный элемент
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());//класс Select входит в библиотеку Селениум и предназначен
        //для работы с выпадающими списками
        //передаем идентификатор group.id - содержит инфу о группах в индектификаторе value

    }


    private void submitContactCreation() {
        manager.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }


    public void removeContact(ContactData contacts) {
        openContactsPage(By.linkText("home"));
        selectContact(contacts);
        removeSelectedContact();
        manager.driver.switchTo().alert().accept();
        manager.driver.findElement(By.cssSelector("div.msgbox"));
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage(By.linkText("home"));
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }

    public void addContactInGroup(ContactData contact, GroupData group) {
        openContactsPage(By.linkText("home"));
        selectFromListGroupNone(group);
        selectContact(contact);
        selectGroupFromList(group);
        manager.driver.findElement(By.name("add")).click();
        //manager.driver.findElement(By.id("1544")).click();
        //click (By.cssSelector(("String.format(\"input[value='%s']\", contact.id()")));
        //selectGroupForContact();
        returnToContactsPage();
    }

    {
        WebElement dropdown = manager.driver.findElement(By.name("group"));
        dropdown.findElement(By.xpath("//option[. = '[all]']")).click();
    }

    public void removeContactFromGroup(ContactData contactRemoveFromGroup, GroupData group) {
        openContactsPage(By.linkText("home"));
        selectFromListGroup(group);
        selectContact(contactRemoveFromGroup);
        manager.driver.findElement(By.name("remove")).click();
        returnToContactsPage();
    }


    public void selectFromListGroup(GroupData group) {
        openContactsPage(By.linkText("home"));
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    private void selectFromListGroupNone(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue("[none]");
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }

    private void selectGroupFromList(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }



    private void selectGroupForContact() {
        manager.driver.findElement(By.cssSelector("select[name='to_group']")).click();

    }

    private void selectContactForGroup(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));
    }

    private void removeSelectedContact() {
        manager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
    }


    public int getCountContact() {
        openContactsPage(By.linkText("home"));
        return manager.driver.findElements(By.name("entry")).size();

    }

    public void removeSelectedContacts() {
        click(By.cssSelector("input[value='Delete']"));
        manager.driver.switchTo().alert().accept();
    }

    public void removeAllContacts() {
        openContactsPage(By.linkText("home"));
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.cssSelector("#maintable input[type='checkbox']:first-child"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getListContacts() {
        openContactsPage(By.linkText("home"));
        var contacts = new ArrayList<ContactData>();// пустой список для контактов
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            //var row = tr.getText();
            var cells = tr.findElements(By.tagName("td"));
            //var checkbox = tr.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child"));
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            var lastname = cells.get(1).getText();
            var firstname = cells.get(2).getText();
            var phone = cells.get(5).getText();

            contacts.add(new ContactData().withId(id).withFirstName(firstname).withLastName(lastname).withPhone(phone));
            //contacts.add(new ContactData().withName(name));
        }
        return contacts;
    }

    private void returnToContactsPage() {
        manager.driver.findElement(By.linkText("home")).click();
    }

    private void submitContactModification() {
        manager.driver.findElement(By.name("update")).click();

    }

    /*@Override
    protected void click(By locator) {
        super.click(locator);
    }*/


    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("mobile"), contact.phone());
        attach(By.name("photo"), contact.photo());

    }

    public void type(By locator, String contact) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(contact);

    }


    private void initContactModification(ContactData contact) {

        click(By.cssSelector(String.format("a[href^='edit.php?id=%s'] img", contact.id())));
        //manager.driver.findElement(By.cssSelector("[title='Edit']")).click();
    }





    public String getEmail(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[5]", contact.id()))).getText();

    }

    public String getAddress(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[4]", contact.id()))).getText();

    }
   /* public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(
                String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();

    }*/

   public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
        }
    }


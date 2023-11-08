package manager;

import java.util.List;

import model.ContactData;

import model.GroupData;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;

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
        returnToContactsPage();    }

    private void submitContactCreation() {
        manager.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

   


    public void removeContact(ContactData contacts) {
        openContactsPage(By.linkText("home"));
        selectContact(contacts);
        removeSelectedContact();
        MatcherAssert.assertThat(manager.driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
        manager.driver.switchTo().alert().accept();
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openContactsPage(By.linkText("home"));
        selectContact(contact);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }

    private void removeSelectedContact() {
        manager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
    }

    private void selectContact(ContactData contact) {
        //manager.driver.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child")).click();
        click (By.cssSelector(String.format("input[value='%s']",contact.id())));
        //manager.driver.findElement(By.cssSelector("#maintable input[type='checkbox']")).click();
        //manager.driver.findElement(By.cssSelector(String.format("#maintable input[type='checkbox']:first-child",contact.id()))).click();
        //manager.driver.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child")),contact.id();

    }

    public int getCountContact() {
        openContactsPage(By.linkText("home"));
        //return manager.driver.findElements(By.cssSelector("#maintable input[type='checkbox']:first-child")).size();
        //return manager.driver.findElements(By.name("selected[]")).size();
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

    /*public List<ContactData> getListContacts() {
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.cssSelector("td.center"));
        for (var td : tds) {
            var name = td.getText();
            var checkbox = td.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child"));
            //var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withName(name));
            //contacts.add(new ContactData().withName(name));
        }
        return contacts;
    }*/
    public List<ContactData> getListContacts() {
        openContactsPage(By.linkText("home"));
        var contacts = new ArrayList<ContactData>();// пустой список для контактов
        var trs = manager.driver.findElements(By.name("entry"));
        for (var tr : trs) {
            var name = tr.getText();
            //var checkbox = tr.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child"));
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withName(name));
            //contacts.add(new ContactData().withName(name));
        }
        return contacts;
    }


    /*public List<ContactData> getListContacts() {
        var contacts = new ArrayList<ContactData>();
        var td = manager.driver.findElements(By.cssSelector("td.contact"));
        for (var td : tds){
            var name = td.getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withName(name));
        return contacts;
    }*/





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
        type(By.name("firstname"), contact.name());
        type(By.name("lastname"), contact.lastname());
        type(By.name("mobile"), contact.phone());

    }

    public void type(By locator, String contact) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(contact);
    }

    private void initContactModification() {
        manager.driver.findElement(By.cssSelector("[title='Edit']")).click();
        
    }
}



    //public void canCreateContact(ContactData contacts) {
    //

package manager;

import java.util.List;

import model.ContactData;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.CoreMatchers.is;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {

        super(manager);
    }

    public void openContactsPage(By home) {
        manager.driver.findElement(home).click();
    }


    public void createContact(ContactData contact) {
        openContactsPage(By.linkText("home"));
        manager.driver.findElement(By.linkText("add new")).click();
        manager.driver.findElement(By.name("firstname")).click();
        manager.driver.findElement(By.name("firstname")).sendKeys(contact.name());
        manager.driver.findElement(By.name("lastname")).click();
        manager.driver.findElement(By.name("lastname")).sendKeys(contact.lastname());
        manager.driver.findElement(By.name("mobile")).click();
        manager.driver.findElement(By.name("mobile")).sendKeys(contact.phone());
        manager.driver.findElement(By.cssSelector("input:nth-child(87)")).click();
        manager.driver.findElement(By.linkText("home")).click();
    }


    public void removeContacts(ContactData contacts) {
        openContactsPage(By.linkText("home"));
        selectContact(contacts);
        manager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
        MatcherAssert.assertThat(manager.driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
        manager.driver.switchTo().alert().accept();
    }

    private void selectContact(ContactData contact) {
        //manager.driver.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child")).click();
        manager.driver.findElement(By.cssSelector(String.format("input[value='%s']",contact.id())));
    }

    public int getCountContact() {
        openContactsPage(By.linkText("home"));
        return manager.driver.findElements(By.cssSelector("#maintable input[type='checkbox']:first-child")).size();
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
        var contacts = new ArrayList<ContactData>();
        //var tds = manager.driver.findElements(By.cssSelector("td.center"));
        var tds = manager.driver.findElements(By.cssSelector("td.odd"));
        for (var td : tds) {
            var name = td.getText();
            var checkbox = td.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child"));
            //var checkbox = td.findElement(By.name("selected[]"));
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



    /*public void modifyContact(ContactData modifiedContact) {
        openContactsPage();
        selectContact(null);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToContactsPage();
    }*/
}

    //public void canCreateContact(ContactData contacts) {
    //

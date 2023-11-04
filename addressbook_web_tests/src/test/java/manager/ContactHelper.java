package manager;

import model.ContactData;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;

import static org.hamcrest.CoreMatchers.is;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {

        super(manager);
    }

    public void openContactsPage(By home) {
        manager.driver.findElement(home).click();
    }

    public boolean isContactPresent() {
        openContactsPage(By.linkText("home"));
        return manager.isElementPresent(By.cssSelector("#maintable input[type='checkbox']:first-child"));
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

    public void removeContact() {
        openContactsPage(By.linkText("home"));
        manager.driver.findElement(By.cssSelector("#maintable input[type='checkbox']:first-child")).click();
        manager.driver.findElement(By.cssSelector("input[value='Delete']")).click();
        MatcherAssert.assertThat(manager.driver.switchTo().alert().getText(), is("Delete 1 addresses?"));
        manager.driver.switchTo().alert().accept();
    }


    //public void canCreateContact(ContactData contacts) {
    //}
}

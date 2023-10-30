package manager;

import model.GroupData;
import org.openqa.selenium.By;

public class GroupHelper {
    private final ApplicationManager manager;

    public GroupHelper(ApplicationManager manager){
        this.manager = manager;
    }

    public void openGroupsPage() {
        if (!manager.isElementPresent(By.name("new"))) {
            click(By.linkText("groups"));

        }
    }

    public boolean isGroupPresent() {
        openGroupsPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupData group) {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void removeGroup() {
        openGroupsPage();
        selectGroup();
        removeSelectedGroup();
        returnToGroupsPage();
    }
    
    public void modifyGroup(GroupData modifiedGroup) {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(modifiedGroup);
        submitGroupModification();
        returnToGroupsPage();
    }

    private void submitGroupCreation() {
        click(By.name("submit"));
    }



    private void initGroupCreation() {
        click(By.name("new"));
    }



    private void removeSelectedGroup() {
        click(By.name("delete"));
    }



    private void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    private void submitGroupModification() {
        click(By.name("update"));
    }

    private void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name());
        type(By.name("group_header"), group.header());
        type(By.name("group_footer"), group.footer());

    }



    private void initGroupModification() {
        click(By.name("edit"));

    }

    private void selectGroup() {
        click(By.name("selected[]"));


    }
    private void click(By locator) {
        manager.driver.findElement(locator).click();
    }
    private void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }
}

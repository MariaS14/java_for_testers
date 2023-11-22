package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper {
}
    public UserHelper(ApplicationManager manager) {
        super(manager);
    }

    public void startCreation(String user) {
        if (isElementPresent(By.className("login-container"))) {
            click(By.xpath("//a[@href='signup_page.php']"));
            type(By.name("username"), username);
            type(By.name("email"), email);
            click(By.xpath("//input[@type='submit']"));
        }
    }
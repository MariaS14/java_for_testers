package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;


import java.time.Duration;
import java.util.regex.Pattern;

public class UserRegistrationTests extends TestBase {


    /*@Test
    void canRegisterUser() {
        //var url = "";
        var username = String.format(CommonFunctions.randomString(6));
        var email = String.format("%s@localhost", username);

        app.jamesCli().addUser(email, "password");
        app.session().signup( username, email);

        var messages = app.mail().receive(email, "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);

        var url = "";
        if (matcher.find()) {
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        app.session().finishedRegistration(url, username, "password");

        Assertions.assertTrue(app.session().isLoggedIn());

        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());

    }
}*/
    @Test
    void canRegisterUser() throws InterruptedException {
        var username = String.format(CommonFunctions.randomString(6));
        var email = String.format("%s@localhost", username);

        app.jamesCli().addUser(email, "password");
        app.session().signup(username, email);

        var messages = app.mail().receive(email, "password", Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);

        var url = "";
        if (matcher.find()) {
            url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        app.session().finishedRegistration(url, username, "password");

        Assertions.assertTrue(app.session().isLoggedIn());

        app.http().login(username, "password");
        Assertions.assertTrue(app.http().isLoggedIn());

    }
}





    //создать пользователя (адрес) на почтовом сервере(JamesHelper)
    /*    app.jamesCli().addUser(email,password);


        //Открываем браузер и заполняем форму создания и отправляем(бразуер)
        app.driver.get("http://localhost/mantisbt-2.26.0/login_page.php");
        app.driver.manage().window().setSize(new Dimension(1184, 784));
        app.driver.findElement(By.linkText("Signup for a new account")).click();
        app.driver.findElement(By.id("email-field")).click();
        app.driver.findElement(By.cssSelector("fieldset")).click();
        app.driver.findElement(By.id("email-field")).sendKeys("pmgtusbm@localhost");
        app.driver.findElement(By.id("username")).click();
        app.driver.findElement(By.id("username")).sendKeys("pmgtusbm");
        app.driver.findElement(By.cssSelector(".width-40")).click();


        //ждем почту(MailHelper)
    /* public static Stream<String> randomUserProvider() {
        Supplier<String> randomUser = () -> CommonFunctions.randomString(10);
        return Stream.generate(randomUser).limit(2);
    }*/

    /* @ParameterizedTest
    @MethodSource("randomUserProvider")
    void canRegisterUser(String username) {
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser(email, password);
        app.registration().initRegistration(username, email);
        var message = app.mail().receive(email, password, Duration.ofSeconds(10)).get(0).content();
        var url = CommonFunctions.extractUrl(message);
        app.mail().drain(email, password);
        app.registration().completeRegistration(url, username, password);
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}*/

        /*var messages = app.mail().receive("user1@localhost", "password", Duration.ofSeconds(60));
        Assertions.assertEquals(1, messages.size());
        System.out.println(messages);
        //извлекаем ссылку из письма
        app.mail().receive("user1@localhost", "password", Duration.ofSeconds(60));
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
        app.http().login("user1", "password");
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
*/

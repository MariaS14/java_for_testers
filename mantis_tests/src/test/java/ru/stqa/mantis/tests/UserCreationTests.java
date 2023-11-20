package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.manager.ApplicationManager;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserCreationTests extends TestBase {

    public static Stream<String> randomUserProvider() {
        Supplier<String> randomUser = () -> CommonFunctions.randomString(10);
        return Stream.generate(randomUser).limit(2);
    }
    @ParameterizedTest
    @MethodSource("randomUserProvider")
    void canCreateUser(String username) {
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

//альтернативный помощник, который действует через удаленный программный интерфейс
    @ParameterizedTest
    @MethodSource("randomUserProvider")
    void canCreateUser(String username) {
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesApi().addUser(email, password);

        app.registration().initRegistration(username, email);

        var message = app.mail().receive(email, password, Duration.ofSeconds(10)).get(0).content();
        var url = CommonFunctions.extractUrl(message);

        app.mail().drain(email, password);
        app.registration().completeRegistration(url, username, password);

        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());
    }
}
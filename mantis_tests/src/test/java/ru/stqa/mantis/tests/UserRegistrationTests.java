package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase{

    @Test

    void canRegisterUser(String username){
        var email = String.format("%s@localhost",username);
        //создать пользователя (адрес) на почтовом сервере(JamesHelper)
        //ткрываем браузер и заполняем форму создания и отправляем(бразуер)
        //ждем почту(MailHelper)
        //извлекаем ссылку из письма
        //возвращаемся в бразуер, проходим по ссылке и завершаем регистрацию пользователя(бразуер)
        //проверяем, что пользователь может залогиниться
        //оздать класс помошник где будут совершаться действия в бразуерах(HttpSessionHelper)
    }
}

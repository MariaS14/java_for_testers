package ru.stqa.mantis.manager.developermail;

import ru.stqa.mantis.model.DeveloperMailUser;

//отве на зпрос добавления пользователя
public record AddUserResponse(Boolean success, Object errors, DeveloperMailUser result) {

}

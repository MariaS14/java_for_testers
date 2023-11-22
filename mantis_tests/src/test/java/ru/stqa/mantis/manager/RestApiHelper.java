/*package ru.stqa.mantis.manager;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.IssuesApi;
import io.swagger.client.api.UserApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.Identifier;
import io.swagger.client.model.Issue;
import io.swagger.client.model.User;
import io.swagger.client.model.UserAddResponse;
import ru.stqa.mantis.model.IssueData;
import ru.stqa.mantis.model.UserRegistration;

public class RestApiHelper extends HelperBase{
    public <ApiKeyAuth> RestApiHelper(ApplicationManager manager) { // используется при инициализации помощника
        super(manager);
        ApiClient defaultClient = Configuration.getDefaultApiClient(); // создаём API клиент
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization"); // вызываем метод, который будет устанавливать ключ авторизации
        Authorization.setApiKey(manager.property("apiKey"));
    }

*/
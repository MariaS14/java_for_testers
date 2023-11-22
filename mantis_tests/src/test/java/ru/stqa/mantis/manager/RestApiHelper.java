package ru.stqa.mantis.manager;

import java.lang.module.Configuration;

public class RestApiHelper extends HelperBase{
    public RestApiHelper(ApplicationManager manager) {
        super(manager);
        ApiClient defaultClient = Configuratio.getDefaultApiClient();
    }
}

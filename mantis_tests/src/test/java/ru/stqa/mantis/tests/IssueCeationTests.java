package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;

public class IssueCeationTests extends TestBase{

    @Test
    void canCreateIssue(new IssueData){
        app.rest().createIssue
    }
}

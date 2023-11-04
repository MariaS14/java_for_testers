package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.CoreMatchers.is;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {

        if (app == null) {
            app = new ApplicationManager();
            app.init(System.getProperty("browser", "firefox"));
        }
    }
}

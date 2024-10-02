package ui_tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ui.core.ApplicationManager;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager("chrome");

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}

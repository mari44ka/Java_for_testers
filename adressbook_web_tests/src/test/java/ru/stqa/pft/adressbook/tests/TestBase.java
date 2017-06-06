package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;

/**
 * Created by Mari on 4/16/17.
 */
public class TestBase {

  public static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }


}

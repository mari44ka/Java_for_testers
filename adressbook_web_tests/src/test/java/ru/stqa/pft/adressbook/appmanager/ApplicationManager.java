package ru.stqa.pft.adressbook.appmanager;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;


import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * Created by Mari on 4/16/17.
 */
public class ApplicationManager {

  WebDriver wd;




  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper;
  private String browser;


  public ApplicationManager(String browser) {
    this.browser = browser;
  }


  public void init() {
    if (Objects.equals(browser, BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (Objects.equals(browser, BrowserType.CHROME)){
      System.setProperty("webdriver.chrome.driver", "/Users/Mari/Downloads/chromedriver");
      wd =new ChromeDriver();

    } else if (Objects.equals(browser, BrowserType.SAFARI)){

      wd = new SafariDriver();
    }

    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    contactHelper = new ContactHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }


  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public ContactHelper contact() {
    return contactHelper;
  }
}
 //my appmanager;


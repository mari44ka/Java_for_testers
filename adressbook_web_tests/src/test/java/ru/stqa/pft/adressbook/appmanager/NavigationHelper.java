package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Mari on 4/17/17.
 */
public class NavigationHelper extends HelperBase {



  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void Gotogrouppage() {
    click(By.linkText("groups"));
  }

  public void returnHomepage() {
    click(By.linkText("home"));
  }
}

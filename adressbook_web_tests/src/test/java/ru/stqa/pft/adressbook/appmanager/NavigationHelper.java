package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/**
 * Created by Mari on 4/17/17.
 */
public class NavigationHelper extends HelperBase {



  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void Gotogrouppage() {
    click(By.linkText("groups"));
  }

  public void returnHomepage() {
    click(By.linkText("home"));
  }
}

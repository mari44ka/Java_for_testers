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
    if (elementIsPresent(By.tagName("h1"))
      && wd.findElement(By.tagName("h1")).getText().equals("Groups")
      && elementIsPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void returnHomepage() {
    if (elementIsPresent(By.id("maintable")))
      return;
    click(By.linkText("home"));
  }
}

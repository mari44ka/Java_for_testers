package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.Contactdata;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {
    super(wd);

  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void fillForm(Contactdata contactdata) {
    type(By.name("firstname"),contactdata.getFirstname());
    type(By.name("lastname"),contactdata.getLastname());
    type(By.name("home"),contactdata.getHomephone());

  }

  public void submitContactform() {
    click(By.name("submit"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void submitContactDelete() {
    click(By.cssSelector("input[type ='button'][value ='Delete']"));
  }

  public void submitAlertWindow() {
    wd.switchTo().alert().accept();
  }
}
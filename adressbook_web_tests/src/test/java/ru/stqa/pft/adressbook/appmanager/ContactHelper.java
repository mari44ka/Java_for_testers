package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.Contactdata;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void fillForm(Contactdata contactdata, boolean creation) {
    type(By.name("firstname"), contactdata.getFirstname());
    type(By.name("lastname"), contactdata.getLastname());
    type(By.name("home"), contactdata.getHomephone());
    type(By.name("company"), contactdata.getCompany());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactdata.getGroup());
    } else {
      Assert.assertFalse(elementIsPresent(By.name("new_group")));
    }
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

  public void initEdit() {
    click(By.xpath("//form[2]/table/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactEdit() {
    click(By.name("update"));
  }


  public void createContact(Contactdata contact, boolean b) {
    addNewContact();
    fillForm(contact,true);
    submitContactform();

  }

  public boolean isThereContact() {
    return elementIsPresent(By.name("selected[]"));
  }
}
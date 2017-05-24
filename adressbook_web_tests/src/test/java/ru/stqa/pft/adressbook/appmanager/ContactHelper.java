package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
  }

  public void submitContactDelete() {
    click(By.cssSelector("input[type ='button'][value ='Delete']"));
  }

  public void submitAlertWindow() {
    wd.switchTo().alert().accept();
  }

  public void initEdit(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void submitContactEdit() {
    click(By.name("update"));
  }

  public int сount() {
    return wd.findElements(By.name("selected[]")).size();
  }


  public void create(Contactdata contact, boolean b) {
    addNewContact();
    fillForm(contact,true);
    submitContactform();
    contactCache = null;

  }

  public boolean isThereContact() {
    return elementIsPresent(By.name("selected[]"));
  }

  public List<Contactdata> list() {
    List<Contactdata> contacts = new ArrayList<Contactdata>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname =cells.get(1).getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      Contactdata contact = new Contactdata().withId(id).withFirstname(firstname).withLastname(lastname);
      contacts.add(contact);
    }
    return contacts;
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstname = cells.get(2).getText();
      String lastname =cells.get(1).getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      Contactdata contact = new Contactdata().withId(id).withFirstname(firstname).withLastname(lastname);
      contactCache.add(contact);
    }
    return new Contacts(contactCache);
  }

  public void modify(int index, Contactdata contact) {
    selectContact(index);
    initEdit(contact.getId());
    fillForm(contact,false);
    submitContactEdit();
  }

  public void delete(int index) {
    selectContact(index);
    submitContactDelete();
    submitAlertWindow();
  }

  public void delete(Contactdata contact) {
    selectContactById(contact.getId());
    submitContactDelete();
    submitAlertWindow();
    contactCache = null;
  }

  public void modify(Contactdata contact) {
    selectContactById(contact.getId());
    initEdit(contact.getId());
    fillForm(contact,false);
    submitContactEdit();
    contactCache = null;

  }
}
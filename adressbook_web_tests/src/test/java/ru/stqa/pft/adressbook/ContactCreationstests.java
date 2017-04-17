package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    addNewContact();
    fillForm(new Contactdata("Tanya", "Good", "510345123"));
    submitForm();
    returnHomepage();
  }

  protected void submitForm() {
    wd.findElement(By.name("submit")).click();
  }
}

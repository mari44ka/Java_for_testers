package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    app.addNewContact();
    app.fillForm(new Contactdata("Tanya", "Good", "510345123"));
    app.submitContactform();
    app.returnHomepage();
  }

}

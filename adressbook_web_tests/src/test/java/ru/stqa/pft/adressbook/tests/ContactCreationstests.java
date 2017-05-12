package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;

import java.util.List;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    app.getNavigationHelper().returnHomepage();
    List<Contactdata>before=app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new Contactdata("Tanya", "Good", "510345123","Google","Test1"),true);
    app.getNavigationHelper().returnHomepage();
    List<Contactdata>after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
  }

}

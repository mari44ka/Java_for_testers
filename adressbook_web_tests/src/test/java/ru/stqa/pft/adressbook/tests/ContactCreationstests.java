package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    app.getNavigationHelper().returnHomepage();
    List<Contactdata>before=app.getContactHelper().getContactList();
    Contactdata contact = new Contactdata("Tanya", "Good", null,null,"Test1");
    app.getContactHelper().createContact(contact,true);
    app.getNavigationHelper().returnHomepage();
    List<Contactdata>after=app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
    //int max =0;
   // for (Contactdata c: after) {
     // if (c.getId() > max) {
        //max = c.getId();
     // }
   // }


   // int max1= after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    contact.setId(after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}

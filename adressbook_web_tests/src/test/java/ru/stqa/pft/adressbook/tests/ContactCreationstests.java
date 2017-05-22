package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    app.goTo().homepage();
    Set<Contactdata> before=app.contact().all();
    Contactdata contact = new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1");
    app.contact().create(contact,true);
    app.goTo().homepage();
    Set<Contactdata>after=app.contact().all();
    Assert.assertEquals(after.size(),before.size()+1);
    //int max =0;
   // for (Contactdata c: after) {
     // if (c.getId() > max) {
        //max = c.getId();
     // }
   // }


   // int max1= after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    //contact.withId(after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

    contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}

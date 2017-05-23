package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationstests extends TestBase{

  @Test
  public void testCreateContact() {
    app.goTo().homepage();
    Contacts before=app.contact().all();
    Contactdata contact = new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1");
    app.contact().create(contact,true);
    app.goTo().homepage();
    Contacts after=app.contact().all();
    assertThat(after.size(),equalTo(before.size()+1));

    //int max =0;
   // for (Contactdata c: after) {
     // if (c.getId() > max) {
        //max = c.getId();
     // }
   // }


   // int max1= after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    //contact.withId(after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

    assertThat(after, equalTo(before.withAdded(contact.
            withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }

}

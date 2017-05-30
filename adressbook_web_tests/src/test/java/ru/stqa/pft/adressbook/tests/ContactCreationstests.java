package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationstests extends TestBase{

  @Test(enabled = false)
  public void testCreateContact() {
    app.goTo().homepage();
    Contacts before=app.contact().all();
    Contactdata contact = new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1");
    app.contact().create(contact,true);
    app.goTo().homepage();
    assertThat(app.contact().сount(),equalTo(before.size()+1));
    Contacts after=app.contact().all();


    //int max =0;
   // for (Contactdata c: after) {
     // if (c.getId() > max) {
        //max = c.getId();
     // }
   // }


   // int max1= after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    //contact.withId(after.stream().max((Comparator<Contactdata>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

    assertThat(after, equalTo(before.withAdded(contact.
            withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));}


  @Test
  public void testContactCreationWithPhoto(){
      app.goTo().homepage();
      app.contact().addNewContact();
      File photo = new File("src/test/resources/Newyear.JPG");
      app.contact().fillForm(new Contactdata().withFirstname("Yulia").withLastname("Goody").withPhoto(photo).withGroup("Test1"),true);
      app.contact().submitContactform();

    }
 // @Test
 // public void testCurrentDir(){
  //  File currentDir = new File("."); // текущая директория
   // System.out.println(currentDir.getAbsolutePath());
    //File photo = new File("src/test/resources/.Newyear.JPG.icloud");
    //System.out.println(photo.getAbsolutePath());
   // System.out.println(photo.exists()); // проверка существования фото
  //}
  }



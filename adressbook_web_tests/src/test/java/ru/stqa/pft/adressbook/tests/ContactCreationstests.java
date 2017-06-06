package ru.stqa.pft.adressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationstests extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));)
    {
      String json = " ";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<Contactdata> contacts = gson.fromJson(json, new TypeToken<List<Contactdata>>() {
      }.getType());
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider ="validContactsFromJson")
  public void testCreateContact(Contactdata contact) {
    app.goTo().homepage();
    Contacts before=app.contact().all();
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


  @Test(enabled = false)
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



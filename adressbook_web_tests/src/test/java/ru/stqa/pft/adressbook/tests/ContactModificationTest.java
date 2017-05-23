package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mari on 4/19/17.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.getGroupHelper().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test3"));
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1"), true);
    }
    else
    if (app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1"), true);
    }
  }


  @Test

  public void testContactModification(){
    app.goTo().homepage();
    Contacts before = app.contact().all();
    Contactdata modifiedContact = before.iterator().next();
    //int index= before.size()-1;
    Contactdata contact = new Contactdata().withId(modifiedContact.getId()).withFirstname("Ulya").withLastname("Good");
    //сохраняем старый модификатор
    app.contact().modify(contact);
    app.goTo().homepage();
    Contacts after= app.contact().all();

    assertThat(before.size(),equalTo(after.size()));

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));



  }
}

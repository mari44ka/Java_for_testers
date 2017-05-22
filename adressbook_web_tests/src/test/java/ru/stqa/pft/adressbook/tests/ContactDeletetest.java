package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;
import java.util.Set;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactDeletetest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.getGroupHelper().create(new GroupData().withName("Test1").withHeader("test2").withFooter("test3"));
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1"), true);
    } else if (app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withGroup("Test1"), true);
    }
  }

  @Test

  public void testContactDelete() {
    app.goTo().homepage();
    Set<Contactdata> before=app.contact().all();
    Contactdata deletedContact = before.iterator().next();
    //int index = before.size()-1;
    app.contact().delete(deletedContact);
    app.goTo().homepage();
    Set<Contactdata> after = app.contact().all();

    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(deletedContact);
    Assert.assertEquals(before,after);
    }


}


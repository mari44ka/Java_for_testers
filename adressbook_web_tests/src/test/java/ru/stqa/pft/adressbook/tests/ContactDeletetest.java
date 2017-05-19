package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactDeletetest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.getGroupHelper().create(new GroupData("Test1", "test2", "test3"));
      app.contact().create(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    } else if (app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.contact().create(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    }
  }

  @Test

  public void testContactDelete() {
    app.goTo().homepage();
    List<Contactdata>before=app.contact().list();
    int index = before.size()-1;
    app.contact().delete(index);
    app.goTo().homepage();
    List<Contactdata> after = app.contact().list();

    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before,after);
    }


}


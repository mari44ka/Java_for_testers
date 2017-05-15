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
    app.getNavigationHelper().Gotogrouppage();
    if (!app.getGroupHelper().isThereGroup()
            && !app.getContactHelper().isThereContact()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
      app.getContactHelper().createContact(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    } else if (app.getGroupHelper().isThereGroup()
            && !app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    }
  }

  @Test

  public void testContactDelete() {
    app.getNavigationHelper().returnHomepage();
    List<Contactdata>before=app.getContactHelper().getContactList();
    int index = before.size()-1;
    app.getContactHelper().deleteContact(index);
    app.getNavigationHelper().returnHomepage();
    List<Contactdata> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(),index);

    before.remove(index);
    Assert.assertEquals(before,after);
    }


}


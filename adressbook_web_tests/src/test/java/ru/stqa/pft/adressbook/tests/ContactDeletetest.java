package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactDeletetest extends TestBase {

  @Test

  public void testContactDelete() {
    app.getNavigationHelper().Gotogrouppage();
    if (!app.getGroupHelper().isThereGroup()
    && !app.getContactHelper().isThereContact()) {
      app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
      app.getContactHelper().createContact(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
      }
      else
        if (app.getGroupHelper().isThereGroup()
            && !app.getContactHelper().isThereContact()) {
      app.getContactHelper().createContact(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    }
    app.getNavigationHelper().returnHomepage();
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDelete();
    app.getContactHelper().submitAlertWindow();
    app.getNavigationHelper().returnHomepage();
    }


  }


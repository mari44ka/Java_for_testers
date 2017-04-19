package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Mari on 4/18/17.
 */
public class ContactDeletetest extends TestBase {

  @Test

  public void testContactDelete(){
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDelete();
    app.getContactHelper().submitAlertWindow();
    app.getNavigationHelper().returnHomepage();
  }
}

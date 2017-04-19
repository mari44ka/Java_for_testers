package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;

/**
 * Created by Mari on 4/19/17.
 */
public class ContactModificationTest extends TestBase {

  @Test

  public void testContactModification(){
    app.getContactHelper().selectContact();
    app.getContactHelper().initEdit();
    app.getContactHelper().fillForm(new Contactdata("Olya", "Good", "510345123"));
    app.getContactHelper().submitContactEdit();
    app.getNavigationHelper().returnHomepage();


  }

}

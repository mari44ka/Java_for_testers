package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;

/**
 * Created by Mari on 5/28/17.
 */
public class ContactDetailEdittest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homepage();
    if (!app.contact().isThereContact()) {
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withWorkphone("+32451").withHomephone("2345").
              withMobilephone("345-34-23").withAddress("Pushkina st").withEmail("").withEmail2("root@gnail.com").withEmail3("mine@ru.com").withGroup("Test1"),true);
    }
  }

  @Test(enabled = false)
  public void testContactDetailEdittest(){
    app.goTo().homepage();
    //app.contact().initDetail(contact);
  }
}

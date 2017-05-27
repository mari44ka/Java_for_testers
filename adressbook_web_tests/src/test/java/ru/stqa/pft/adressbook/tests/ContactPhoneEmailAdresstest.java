package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mari on 5/25/17.
 */
public class ContactPhoneEmailAdresstest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homepage();
    if (!app.contact().isThereContact()) {
      app.contact().create(new Contactdata().withFirstname("Tanya").withLastname("Good").withWorkphone("+32451").withHomephone("2345").
              withMobilephone("345-34-23").withAddress("Pushkina st,Kiev").withEmail("").withEmail2("root@gnail.com").withEmail3("mine@ru.com"),true);
    }
  }



  @Test
  public void testContactPhonneEmailAdress(){
    app.goTo().homepage();
    Contactdata contact = app.contact().all().iterator().next();
    Contactdata infoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHomephone(), equalTo(cleaned(infoFromEditForm.getHomephone())));
    assertThat(contact.getMobilephone(), equalTo(cleaned(infoFromEditForm.getMobilephone())));
    assertThat(contact.getWorkphone(), equalTo(cleaned(infoFromEditForm.getWorkphone())));
    assertThat(contact.getAddress(), equalTo(infoFromEditForm.getAddress()));
    assertThat(contact.getEmail(), equalTo(infoFromEditForm.getEmail()));
    assertThat(contact.getEmail2(), equalTo(infoFromEditForm.getEmail2()));
    assertThat(contact.getEmail3(), equalTo(infoFromEditForm.getEmail3()));

  }
  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}

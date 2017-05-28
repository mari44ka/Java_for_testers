package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Arrays;
import java.util.stream.Collectors;

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
              withMobilephone("345-34-23").withAddress("Pushkina st").withEmail("").withEmail2("root@gnail.com").withEmail3("mine@ru.com").withGroup("Test1"),true);
    }
  }



  @Test
  public void testContactPhoneEmailAdress(){
    app.goTo().homepage();
    Contactdata contact = app.contact().all().iterator().next();
    Contactdata infoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllphones(), equalTo(mergePhones(infoFromEditForm)));

    assertThat(contact.getAddress(), equalTo(infoFromEditForm.getAddress()));
    assertThat(contact.getAllemails(), equalTo(mergeEmails(infoFromEditForm)));


  }

  private String mergeEmails(Contactdata contact) {
    return Arrays.asList(contact.getEmail(),contact.getEmail2(),contact.getEmail3()).
            stream().filter((s) -> !s.equals("")).
            map(ContactPhoneEmailAdresstest::cleaned).collect(Collectors.joining("\n"));

  }

  private String mergePhones(Contactdata contact) {
    return Arrays.asList(contact.getHomephone(),contact.getMobilephone(),contact.getWorkphone()).
            stream().filter((s) -> !s.equals("")).
            map(ContactPhoneEmailAdresstest::cleaned).collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}

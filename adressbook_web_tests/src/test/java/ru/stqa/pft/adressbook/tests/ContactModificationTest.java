package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Mari on 4/19/17.
 */
public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.getGroupHelper().create(new GroupData("Test1", "test2", "test3"));
      app.contact().create(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    }
    else
    if (app.getGroupHelper().isThereGroup()
            && !app.contact().isThereContact()) {
      app.contact().create(new Contactdata("Tanya", "Good", "510345123", "Google", "Test1"), true);
    }
  }


  @Test

  public void testContactModification(){
    app.goTo().homepage();
    List<Contactdata> before = app.contact().list();
    int index= before.size()-1;
    Contactdata contact = new Contactdata(before.get(index).getId(),"Ulya","Good", null,null,null);
    //сохраняем старый модификатор
    app.contact().modify(index, contact);
    app.goTo().homepage();
    List<Contactdata> after= app.contact().list();

    Assert.assertEquals(before.size(),after.size());

    before.remove(index);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after)); // модификация в множества



  }
}

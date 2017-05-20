package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Mari on 4/18/17.
 */
public class GroupModificationtest extends TestBase {

  @BeforeMethod
  public void esurePreconditions() {
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().create(new GroupData().withName("Test2").withHeader("test2").withFooter("test3"));

    }
  }


  @Test
  public void testGroupModification() {
    app.goTo().grouppage();
    List<GroupData> before = app.getGroupHelper().list();
    //int before=app.getGroupHelper().getGroupCount();
    int index = before.size() - 1;
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("Test1").withHeader("test3");
    app.getGroupHelper().modify(index, group);
    app.goTo().grouppage();
    List<GroupData> after = app.getGroupHelper().list();
    //int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(), after.size());
    before.remove(index);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));// преобразование в множества
  }
}




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
    app.getNavigationHelper().Gotogrouppage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().createGroup(new GroupData("Test2", "test2", "test3"));

    }
  }


  @Test
  public void testGroupModification() {
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before=app.getGroupHelper().getGroupCount();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "Test1", "test3", null);
    app.getGroupHelper().Modifygroup(index, group);
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(), after.size());
    before.remove(index);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));// преобразование в множества
  }
}




package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Mari on 4/18/17.
 */
public class GroupModificationtest extends TestBase{



  @Test
  public void testGroupModification(){
    app.getNavigationHelper().Gotogrouppage();
    if (! app.getGroupHelper().isThereGroup()){
      app.getGroupHelper().createGroup(new GroupData("Test2", "test2", "test3"));
    }
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> before=app.getGroupHelper().getGroupList();
    //int before=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectgroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group =new GroupData(before.get(before.size()-1).getId(),"Test1", "test3", null);
    app.getGroupHelper().fillForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    //int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(),after.size());
    before.remove(before.size()-1);
    before.add(group);

    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));// преобразование в множества
  }

}

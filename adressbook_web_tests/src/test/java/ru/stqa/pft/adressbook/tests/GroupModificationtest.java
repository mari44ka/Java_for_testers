package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

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
    app.getGroupHelper().selectgroup(0);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("Test2", "test3", null));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> after=app.getGroupHelper().getGroupList();
    //int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(),after.size());

  }

}

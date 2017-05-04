package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

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
    int before=app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectgroup(1);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("Test2", "test3", null));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().Gotogrouppage();
    int after=app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before,after);

  }

}

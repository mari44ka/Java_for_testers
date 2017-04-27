package ru.stqa.pft.adressbook.tests;

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
      app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
    }
    app.getNavigationHelper().Gotogrouppage();
    app.getGroupHelper().selectgroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillForm(new GroupData("Test2", "test3", " "));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().Gotogrouppage();

  }

}

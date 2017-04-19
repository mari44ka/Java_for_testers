package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationtests extends TestBase{


  @Test
  public void testGroupCreation() {

    app.getNavigationHelper().Gotogrouppage();
    app.getGroupHelper().createNewGroup();
    app.getGroupHelper().fillForm(new GroupData("Test1", "test2", "test3"));
    app.getGroupHelper().submitGroupForm();
    app.getNavigationHelper().Gotogrouppage();
  }

}


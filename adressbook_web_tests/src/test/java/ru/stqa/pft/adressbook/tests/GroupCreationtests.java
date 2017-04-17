package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationtests extends TestBase{


  @Test
  public void testGroupCreation() {

    app.Gotogrouppage();
    app.createNewGroup();
    app.fillForm(new GroupData("Test1", "test2", "test3"));
    app.submitGroupForm();
    app.Gotogrouppage();
  }

}


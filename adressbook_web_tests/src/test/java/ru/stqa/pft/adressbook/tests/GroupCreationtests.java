package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;

public class GroupCreationtests extends TestBase{


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().Gotogrouppage();
    int before=app.getGroupHelper().getGroupCount(); // узнаем количество групп до добавления
    app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
    app.getNavigationHelper().Gotogrouppage();
    int after = app.getGroupHelper().getGroupCount(); // узнаем количество групп после добавления
    Assert.assertEquals(after,before+1);// проверка, что группа добавилась
  }

}


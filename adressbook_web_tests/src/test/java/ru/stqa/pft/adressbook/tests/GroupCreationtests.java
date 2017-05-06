package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupCreationtests extends TestBase{


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData>before=app.getGroupHelper().getGroupList(); // переменная before поменялось,
    // теперь она содержит не количество элементов, а список
    //int before=app.getGroupHelper().getGroupCount(); // узнаем количество групп до добавления
    app.getGroupHelper().createGroup(new GroupData("Test1", "test2", "test3"));
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData>after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount(); // узнаем количество групп после добавления
    Assert.assertEquals(after.size(),before.size()+1);// проверка, что группа добавилась;
    // когда меняем переменную after, меняется на after.size()
  }

}


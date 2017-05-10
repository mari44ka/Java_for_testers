package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationtests extends TestBase {


  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> before = app.getGroupHelper().getGroupList(); // переменная before поменялось,
    // теперь она содержит не количество элементов, а список
    //int before=app.getGroupHelper().getGroupCount(); // узнаем количество групп до добавления
    GroupData group = new GroupData("Test4", "test2", "test3");
    app.getGroupHelper().createGroup(group);
    app.getNavigationHelper().Gotogrouppage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount(); // узнаем количество групп после добавления
    Assert.assertEquals(after.size(), before.size() + 1);// проверка, что группа добавилась;
    // когда меняем переменную after, меняется на after.size()

    //int max =0;
    //for (GroupData g: after){   //находим максимальный id
    //if (g.getId()>max){
    //max=g.getId();

    //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
    int max =after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));


  }

}

// we replaced comparartor with lamda
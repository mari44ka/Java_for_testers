package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mari on 4/18/17.
 */
public class GroupModificationtest extends TestBase {

  @BeforeMethod
  public void esurePreconditions() {
    app.goTo().grouppage();
    if (!app.getGroupHelper().isThereGroup()) {
      app.getGroupHelper().create(new GroupData().withName("Test2").withHeader("test2").withFooter("test3"));

    }
  }


  @Test
  public void testGroupModification() {
    app.goTo().grouppage();
    Groups before = app.getGroupHelper().all();
    //int before=app.getGroupHelper().getGroupCount();
    GroupData modifiedGroup =before.iterator().next();

    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("Test1").withHeader("test3");
    app.getGroupHelper().modify(group);
    app.goTo().grouppage();

    Groups after = app.getGroupHelper().all();
    //int after=app.getGroupHelper().getGroupCount();
    assertThat(before.size(), equalTo(after.size()));

    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    // преобразование в множества
  }
}




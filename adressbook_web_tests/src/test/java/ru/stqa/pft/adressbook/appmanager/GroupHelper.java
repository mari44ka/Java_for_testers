package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mari on 4/17/17.
 */
public class GroupHelper extends HelperBase {

  public int сount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void fillForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());

  }

  public void createNewGroup() {
    click(By.name("new"));
  }

  public void deletegroup() {
    click(By.name("delete"));
  }

  public void selectgroup(int index) {

    wd.findElements(By.name("selected[]")).get(index).click(); //we can select any group we want
  }

  public void selectGroupbyId(int id) {

    wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); //we can select any group we want
  }

  public void submitGroupForm() {
    click(By.name("submit"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    createNewGroup();
    fillForm(group);
    submitGroupForm();
    groupCache = null;

  }

  public boolean isThereGroup() {
    return elementIsPresent(By.name("selected[]"));
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null) {
      return new Groups(groupCache);
    }

    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      //String id = element.findElement(By.tagName("input")).getAttribute("value");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData().withId(id).withName(name);
      groupCache.add(group);
    }
    return new Groups(groupCache);
  }

  public List<GroupData> list () {
      List<GroupData> groups = new ArrayList<GroupData>();
      List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
      for (WebElement element : elements) {
        String name = element.getText();
        //String id = element.findElement(By.tagName("input")).getAttribute("value");
        int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        GroupData group = new GroupData().withId(id).withName(name);
        groups.add(group);
      }
      return groups;
    }


  public void delete(int index) {
    selectgroup(index);
    deletegroup();
  }

  public void delete(GroupData group) {
    selectGroupbyId(group.getId());
    deletegroup();
    groupCache = null;
  }

  public void modify(int index, GroupData group) {
    selectgroup(index);
    initGroupModification();
    fillForm(group);
    submitGroupModification();

  }


  public void modify(GroupData group) {
    selectGroupbyId(group.getId());
    initGroupModification();
    fillForm(group);
    submitGroupModification();
    groupCache = null;
  }


}


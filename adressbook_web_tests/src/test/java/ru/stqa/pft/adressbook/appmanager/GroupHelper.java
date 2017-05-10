package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mari on 4/17/17.
 */
public class GroupHelper extends HelperBase {

  public int getGroupCount() {
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

  public void submitGroupForm() {
    click(By.name("submit"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void createGroup(GroupData group) {
    createNewGroup();
    fillForm(group);
    submitGroupForm();

  }

  public boolean isThereGroup() {
    return elementIsPresent(By.name("selected[]"));
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements){
      String name =element.getText();
      String id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupData group = new GroupData(id, name, null,null);
      groups.add(group);
    }
    return groups;
  }
}


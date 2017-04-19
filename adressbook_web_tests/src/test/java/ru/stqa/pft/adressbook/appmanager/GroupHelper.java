package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.GroupData;

/**
 * Created by Mari on 4/17/17.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
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

  public void selectgroup() {
    click(By.name("selected[]"));
  }

  public void submitGroupForm() {
    click(By.name("submit"));
  }
}

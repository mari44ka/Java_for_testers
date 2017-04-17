package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class GroupCreationtests extends TestBase{


  @Test
  public void testGroupCreation() {

    Gotogrouppage();
    createNewGroup();
    fillForm(new GroupData("Test1", "test2", "test3"));
    submitForm();
    Gotogrouppage();
  }

  protected void submitForm() {
    wd.findElement(By.name("submit")).click();
  }
}


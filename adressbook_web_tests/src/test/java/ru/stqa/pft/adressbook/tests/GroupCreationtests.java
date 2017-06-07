package ru.stqa.pft.adressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class GroupCreationtests extends TestBase {



  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")));){
    String xml = " ";
    String line = reader.readLine();
    while (line!= null){
      xml+=line;
      line =reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupData.class);
    List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
    return groups.stream().map((g)->new Object[] {g}).collect(Collectors.toList()).iterator();}

  }
  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")));) {
      String json = " ";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
      }.getType());
      return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }


  @Test(dataProvider ="validGroupsFromJson")
  public void testGroupCreation(GroupData group) {

    app.goTo().grouppage();
    Groups before = app.group().all(); //теперь работаем с множеством, а не списками
    //List<GroupData> before = app.getGroupHelper().list(); // переменная before поменялось,
    // теперь она содержит не количество элементов, а список
    //int before=app.getGroupHelper().сount(); // узнаем количество групп до добавления
    app.group().create(group);
    app.goTo().grouppage();
    assertThat(app.group().сount(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    //List<GroupData> after = app.getGroupHelper().list();
    //int after = app.getGroupHelper().сount(); // узнаем количество групп после добавления

    // когда меняем переменную after, меняется на after.size()

    //int max =0;
    //for (GroupData g: after){   //находим максимальный id
    //if (g.getId()>max){
    //max=g.getId();

    //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(),o2.getId());
   // int max =after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
   // group.withId(max);


    //before.add(group);
    //Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
   // Assert.assertEquals(before,after); // множествами нам надо перегенерировать метод equals

    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));


  }

}

// we replaced comparartor with lamda
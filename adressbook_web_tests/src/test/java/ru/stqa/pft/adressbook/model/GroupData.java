package ru.stqa.pft.adressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
@XStreamAlias("group") //чтобы не было видно тега, меняем его на групс
public class GroupData {
  @XStreamOmitField
  private  int id = Integer.MAX_VALUE; // добавляем, чтобы можно было сравнивать группы при их модификации( при проверке)
  @Expose
  private  String name;
  @Expose
  private  String header;
  @Expose
  private  String footer;

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    if (id != groupData.id) return false;
    return name != null ? name.equals(groupData.name) : groupData.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "GroupData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }

  //public GroupData( String name, String header, String footer) {  // создали новый конструктор, чтобы не было ошибки компиляции в тесте модификации контактов
    //this.id = 0;
    //this.name = name;
    //this.header = header;
    //this.footer = footer;
  //}

  //public GroupData(int id, String name, String header, String footer) {
    //this.id = id;
    //this.name = name;
    //this.header = header;      //удалили конструктор,тк используем fluent interface
    //this.footer = footer;
  //}

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }
  public int getId(){ return id;}


  public GroupData withId(int id) {
    this.id = id;
    return this;
  }
}





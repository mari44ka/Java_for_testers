package ru.stqa.pft.adressbook.model;

public class GroupData {
  public void setId(int id) {
    this.id = id;
  }

  private  int id; // добавляем, чтобы можно было сравнивать группы при их модификации( при проверке)
  private final String name;
  private final String header;
  private final String footer;

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

  public GroupData( String name, String header, String footer) {  // создали новый конструктор, чтобы не было ошибки компиляции в тесте модификации контактов
    this.id = 0;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  public GroupData(int id, String name, String header, String footer) {
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

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

    }





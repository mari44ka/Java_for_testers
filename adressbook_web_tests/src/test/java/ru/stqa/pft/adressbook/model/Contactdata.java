package ru.stqa.pft.adressbook.model;

public class Contactdata {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String homephone;
  private String company;
  private String group;

  public Contactdata(String firstname, String lastname, String homephone,String company,String group) {
    this.id=0;
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
    this.company = company;
    this.group = group;
  }

  public Contactdata(int id,String firstname, String lastname, String homephone,String company,String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
    this.company = company;
    this.group = group;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contactdata that = (Contactdata) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Contactdata{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public int getId(){return id;}
  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getHomephone() {
    return homephone;
  }

  public String getCompany() {
    return company;
  }

  public String getGroup() {
    return group;
  }

}

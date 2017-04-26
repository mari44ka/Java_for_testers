package ru.stqa.pft.adressbook.model;

public class Contactdata {
  private final String firstname;
  private final String lastname;
  private final String homephone;
  private String company;
  private String group;

  public Contactdata(String firstname, String lastname, String homephone,String company,String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
    this.company = company;
    this.group = group;
  }

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

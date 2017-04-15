package ru.stqa.pft.adressbook;

public class Contactdata {
  private final String firstname;
  private final String lastname;
  private final String homephone;

  public Contactdata(String firstname, String lastname, String homephone) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.homephone = homephone;
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
}

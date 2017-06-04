package ru.stqa.pft.adressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("contact")
public class Contactdata {
  @XStreamOmitField
  private int id;
  @Expose
  private  String firstname;
  @Expose
  private  String lastname;
  @Expose
  private String homephone;
  private String workphone;
  private String mobilephone;
  private String allphones;
  @Expose
  private String address;
  private File photo;

  public Contactdata withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public File getPhoto() {
    return photo;
  }

  public void setAllemails(String allemails) {
    this.allemails = allemails;
  }

  private String allemails;
  private String email;
  private String email2;
  private String email3;

  public Contactdata withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  @Override
  public String toString() {
    return "Contactdata{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", homephone='" + homephone + '\'' +
            ", workphone='" + workphone + '\'' +
            ", mobilephone='" + mobilephone + '\'' +
            ", address='" + address + '\'' +
            ", email='" + email + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", company='" + company + '\'' +
            ", group='" + group + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Contactdata that = (Contactdata) o;

    if (id != that.id) return false;
    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
    if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
    if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
    result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
    result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }

  public Contactdata withAllemails(String allemails) {
    this.allemails = allemails;
    return this;
  }

  public Contactdata withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public Contactdata withEmail(String email) {
    this.email = email;
    return this;
  }

  public Contactdata withAddress(String address) {
    this.address = address;
    return this;
  }

  public Contactdata withAllphones(String allphones) {
    this.allphones = allphones;
    return this;
  }

  public Contactdata withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public Contactdata withWorkphone (String workphone) {
    this.workphone = workphone;
    return this;
  }


  public Contactdata withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public Contactdata withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public Contactdata withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  private String company;
  private String group;

 // public Contactdata(String firstname, String lastname, String homephone,String company,String group) {
    //this.id=0;
    //this.firstname = firstname;
    //this.lastname = lastname;
    //this.homephone = homephone;
    //this.company = company;
    //this.group = group;
  //}

  //public Contactdata(int id,String firstname, String lastname, String homephone,String company,String group) {
    //this.id = id;
    //this.firstname = firstname;
    //this.lastname = lastname;
    //this.homephone = homephone;
    //this.company = company;
    //this.group = group;

  //}

  public Contactdata withCompany(String company) {
    this.company = company;
    return this;
  }

  public Contactdata withGroup(String group) {
    this.group = group;
    return this;
  }

  public Contactdata withId(int id) {

    this.id = id;
    return this;
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

  public String getWorkphone() {
    return workphone;
  }

  public String getMobilephone() {
    return mobilephone;
  }

  public String getAllphones() {
    return allphones;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail3() {
    return email3;
  }

  public String getEmail2() {

    return email2;
  }

  public String getEmail() {

    return email;
  }

  public String getAllemails() {
    return allemails;
  }
}

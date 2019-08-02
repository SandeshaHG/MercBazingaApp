package com.merc.bazinga.application.shopify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "merccustomers")
public class customers {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int customerid;
  private String email;
  private String firstname;
  private String lastname;
  private String phone;
  private String city;
  private String country;

  public int getCustomerid() {
    return customerid;
  }

  public void setCustomerid(int customerid) {
    this.customerid = customerid;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public customers() {
  }

  public customers(int customerid, String email, String firstname, String lastname, String phone, String city, String country) {
    this.customerid = customerid;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.phone = phone;
    this.city = city;
    this.country = country;
  }
}

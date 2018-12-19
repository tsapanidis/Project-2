package com.jp2.model;

import com.jp2.domain.enumerations.UserType;

public class OwnerModel {

    private long ID;
    private int vat;
    private String firstName;
    private String lastName;
    private String address;
    private UserType usertype;
    private String email;
    private String password;
    private String brand;
    private String plate;


    public long getID() {
        return ID;
    }

    public void setID(long ownerID) {
        this.ID = ownerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getVAT() {
        return vat;
    }

    public void setVAT(int vat) {
        this.vat = vat;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }
}

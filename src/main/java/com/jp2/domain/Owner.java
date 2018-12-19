package com.jp2.domain;

import com.jp2.domain.enumerations.UserType;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="OWNERS",uniqueConstraints = {@UniqueConstraint(columnNames = {"VAT"})})
public class Owner {
    @Id
    @Column(name="ID_OWNER",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerID;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="E_MAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="BRAND")
    private String brand;

    @Column(name="PLATE")
    private String plate;

    @Column(name="VAT")
    private int vat;

    @Column(name="USER_TYPE")
    private UserType usertype;

    @OneToMany(mappedBy="owner",targetEntity=Repair.class ,cascade = CascadeType.REMOVE)
    private Collection repairs;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Owner() {
    }


    public Owner(String firstName, String lastName, String address, String email, String password, String brand, String plate, int vat, UserType usertype) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.brand = brand;
        this.plate = plate;
        this.vat = vat;
        this.usertype = usertype;
    }

    public long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(long ownerID) {
        this.ownerID = ownerID;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public int getVAT() {
        return vat;
    }

    public void setVAT(int VAT) {
        this.vat = VAT;
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

    @Override
    public String toString() {
        return "" +
                "firstName: '" + firstName + '\'' +
                " | lastName: '" + lastName + '\'' +
                " | address: '" + address + '\'' +
                " | email: '" + email + '\'' +
                " | password: '" + password + '\'' +
                " | brand: '" + brand + '\'' +
                " | plate: '" + plate + '\'' +
                " | vat: " + vat +
                " | usertype: " + usertype;
    }
}

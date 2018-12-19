package com.jp2.forms;

import com.jp2.domain.enumerations.UserType;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterForm {

    private static final String NAME_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String ADDRESS_PATTERN = "[A-Za-z]+\\s[0-9]+";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final String EMAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";

    private static  final String PLATE_PATTERN = "[A-Z]{3}-[0-9]{4}";

    private static  final String VAT_PATTERN = "[0-9]{9}";

    private static final int PASSWORD_MINSIZE = 6;

    @Pattern(regexp = NAME_PATTERN , message = "Invalid Firstname")
    private String firstName;

    @Pattern(regexp = NAME_PATTERN , message = "Invalid Lastname")
    private String lastName;

    @Pattern(regexp = ADDRESS_PATTERN , message = "Invalid Address")
    private String address;

    @Pattern(regexp = EMAIL_PATTERN , message = "Invalid Email")
    private String email;

    @Pattern(regexp = PASSWORD_PATTERN , message = "Invalid Password")
    @Size(min = PASSWORD_MINSIZE , message = "Invalid Password Size")
    private String password;

    @Pattern(regexp = NAME_PATTERN , message = "Invalid Brand")
    private String brand;

    @Pattern(regexp = PLATE_PATTERN , message = "Invalid Plate")
    private String plate;

    private long id;

    @Pattern(regexp = VAT_PATTERN , message = "Invalid Vat")
    private String vat;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    private UserType usertype;


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

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

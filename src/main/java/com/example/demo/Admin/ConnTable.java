package com.example.demo.Admin;

public class ConnTable {

    String Account_number, First_name, Last_name, Middle_name, date_of_birth, address, zipp_code, state, Country, city, contact_no, ssn, username, email;

    public ConnTable(String Account_number,String  First_name,String  Last_name,String  Middle_name,String  date_of_birth,
                     String address,String  zipp_code,String  state,String  Country,String  city,String  contact_no,String  ssn,String  username,String  email){
        this.Account_number = Account_number;
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Middle_name = Middle_name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.zipp_code = zipp_code;
        this.state = state;
        this.Country = Country;
        this.city = city;
        this.contact_no = contact_no;
        this.ssn = ssn;
        this.username = username;
        this.email = email;
    }

    public String getAccount_number() {
        return Account_number;
    }

    public void setAccount_number(String account_number) {
        Account_number = account_number;
    }

    public String getFirst_name()  {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public String getMiddle_name() {
        return Middle_name;
    }

    public void setMiddle_name(String middle_name) {
        Middle_name = middle_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipp_code() {
        return zipp_code;
    }

    public void setZipp_code(String zipp_code) {
        this.zipp_code = zipp_code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

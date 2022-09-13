package com.example.demo.Admin;


import javafx.beans.property.SimpleStringProperty;

public class ConnTable {
    private final SimpleStringProperty Account_number;
    private final SimpleStringProperty First_name, Last_name, Middle_name, date_of_birth, address, zipp_code, state, Country, city, contact_no, ssn, username, email;

    public ConnTable(String Account_number,String  First_name,String  Last_name,String  Middle_name,String  date_of_birth,
                     String address,String  zipp_code,String  state,String  Country,String  city,String  contact_no,String  ssn,String  username,String  email){
        this.Account_number =new SimpleStringProperty(Account_number);
        this.First_name =new SimpleStringProperty(First_name);
        this.Last_name =new SimpleStringProperty(Last_name);
        this.Middle_name =new SimpleStringProperty(Middle_name);
        this.date_of_birth =new SimpleStringProperty(date_of_birth);
        this.address =new SimpleStringProperty(address);
        this.zipp_code =new SimpleStringProperty(zipp_code);
        this.state =new SimpleStringProperty(state);
        this.Country =new SimpleStringProperty(Country);
        this.city =new SimpleStringProperty(city);
        this.contact_no =new SimpleStringProperty(contact_no);
        this.ssn =new SimpleStringProperty(ssn);
        this.username =new SimpleStringProperty(username);
        this.email =new SimpleStringProperty(email);
    }

    public String getAccount_number() {
        return Account_number.get();
    }

    public void setAccount_number(String account_number) {
        this.Account_number.set(account_number);
    }

    public String getFirst_name()  {
        return First_name.get();
    }

    public void setFirst_name(String first_name) {
       this.First_name.set(first_name);
    }

    public String getLast_name() {
        return Last_name.get();
    }

    public void setLast_name(String last_name) {
       this.Last_name.set(last_name);
    }

    public String getMiddle_name() {
        return Middle_name.get();
    }

    public void setMiddle_name(String middle_name) {
        this.Middle_name.set(middle_name);
    }

    public String getDate_of_birth() {
        return date_of_birth.get();
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth.set(date_of_birth);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getZipp_code() {
        return zipp_code.get();
    }

    public void setZipp_code(String zipp_code) {
        this.zipp_code.set(zipp_code);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public String getCountry() {
        return Country.get();
    }

    public void setCountry(String country) {
        this.Country.set(country);
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getContact_no() {
        return contact_no.get();
    }

    public void setContact_no(String contact_no) {
        this.contact_no.set(contact_no);
    }

    public String getSsn() {
        return ssn.get();
    }

    public void setSsn(String ssn) {
        this.ssn.set(ssn);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}

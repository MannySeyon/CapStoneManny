package com.example.demo.customer;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Customer {

        private String firstName;
        private String lastName;
        private String middleName;
        private LocalDate dateOfBirth;
        private String SSN;
        private String phoneNumber;
        private String email;
        private String username;
        private String password;
        private String accountNumber;

        public Customer(String firstName,
                        String lastName,
                        String middleName,
                        LocalDate dateOfBirth,
                        String SSN,
                        String phoneNumber,
                        String email,
                        String username,
                        String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.dateOfBirth = dateOfBirth;
            this.SSN = SSN;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.username = username;
            this.password = password;

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

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getSSN() {
            return SSN;
        }

        public void setSSN(String  SSN) {
            this.SSN = SSN;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }


        @Override
        public String toString() {
            return "Customer{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", SSN='" + SSN + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", email='" + email + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", accountNumber='" + accountNumber + '\'' +
                    '}';
        }

    }


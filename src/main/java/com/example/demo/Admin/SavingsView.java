package com.example.demo.Admin;

import javafx.beans.property.SimpleStringProperty;

public class SavingsView {

    private final SimpleStringProperty Savings_account_number, Account_number, account_balance;

    public SavingsView(String saving_acc_number, String acc_number, String acc_bal) {

        this.Savings_account_number =new SimpleStringProperty(saving_acc_number);
        this.Account_number =new SimpleStringProperty(acc_number);
        this.account_balance =new SimpleStringProperty(acc_bal);

}

    public String getSavings_account_number() {
        return Savings_account_number.get();
    }

    public void setSavings_account_number(String saving_acc_number){
        this.Savings_account_number.set(saving_acc_number);
    }

    public String getAccount_number() {
        return Account_number.get();
    }

    public void setAccount_number(String acc_number){
        this.Account_number.set(acc_number);
    }

    public String getAccount_balance(){
            return account_balance.get();
        }

    public void setAccount_balance(String acc_number){
        this.account_balance.set(acc_number);
    }

}


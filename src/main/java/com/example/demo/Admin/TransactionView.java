package com.example.demo.Admin;

import javafx.beans.property.SimpleStringProperty;


public class TransactionView {

    private final SimpleStringProperty Transaction_number, Account_number, Date_Created, income_date, income_deposit, income_amount, expense_date, expense_supplier, expense_amount;

    public  TransactionView (String Transaction_Number ,String Account_Number,String  Date_created,String  income_date,String  income_deposit,String  income_amount,
                     String expense_date,String  expense_supplier,String  expense_amount){
        this.Transaction_number = new SimpleStringProperty(Transaction_Number);
        this.Account_number =new SimpleStringProperty(Account_Number);
        this.Date_Created =new SimpleStringProperty(Date_created);
        this.income_date =new SimpleStringProperty(income_date);
        this.income_deposit =new SimpleStringProperty(income_deposit);
        this.income_amount =new SimpleStringProperty(income_amount);
        this.expense_date =new SimpleStringProperty(expense_date);
        this.expense_supplier =new SimpleStringProperty(expense_supplier);
        this.expense_amount =new SimpleStringProperty(expense_amount);

    }


    public String getTransaction_number() {
        return Transaction_number.get();
    }

    public void setTransaction_number(String Transaction_Number) {
        this.Transaction_number.set(Transaction_Number);
    }


    public String getAccount_number() {
        return Account_number.get();
    }

    public void setAccount_number(String account_Number) {
        this.Account_number.set(account_Number);
    }

    public String getDate_Created()  {
        return Date_Created.get();
    }

    public void setFirst_name(String Date_created) {
        this.Date_Created.set(Date_created);
    }

    public String getIncome_date() {
        return income_date.get();
    }

    public void setIncome_date(String income_date) {
        this.income_date.set(income_date);
    }

    public String getIncome_deposit() {
        return income_deposit.get();
    }

    public void setMiddle_name(String income_deposit) {
        this.income_deposit.set(income_deposit);
    }

    public String getIncome_amount() {
        return income_amount.get();
    }

    public void setIncome_amount(String income_amount) {
        this.income_amount.set(income_amount);
    }

    public String getExpense_date() {
        return expense_date.get();
    }

    public void setExpense_date(String expense_date) {
        this.expense_date.set(expense_date);
    }

    public String getExpense_supplier() {
        return expense_supplier.get();
    }

    public void setExpense_supplier(String expense_supplier) {
        this.expense_supplier.set(expense_supplier);
    }

    public String getExpense_amount() {
        return expense_amount.get();
    }

    public void setExpense_amount(String expense_amount) {
        this.expense_amount.set(expense_amount);
    }

}

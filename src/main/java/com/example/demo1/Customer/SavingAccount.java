package com.example.demo1.Customer;
import java.time.LocalDate;
public class SavingAccount extends Customer implements Balance {

    private long SavingAccountNumber;
    private long balance = 0;
    private long withdrawalAmount;
    private long depositAmount;

    public SavingAccount(String firstName,
                         String lastName,
                         String middleName,
                         LocalDate dateOfBirth,
                         String SSN,
                         String phoneNumber,
                         String email,
                         String username,
                         String password,
                         long savingAccountNumber) {
        super(firstName,
                lastName,
                middleName,
                dateOfBirth,
                SSN,
                phoneNumber,
                email,
                username,
                password);
        SavingAccountNumber = savingAccountNumber;
    }


    @Override
    public long withdrawal(long balance, long withdrawalAmount) throws Exception {
        if(balance >= withdrawalAmount){
            this.balance = balance - withdrawalAmount;
        }
        else{
            throw new Exception("Error");
        }

        return this.balance;
    }

    @Override
    public long deposit(long balance, long depositAmount) throws Exception{
        if(balance >= depositAmount){
            this.balance = balance - depositAmount;
        }
        else{
            throw new Exception("Error");
        }

        return this.balance;
    }
}

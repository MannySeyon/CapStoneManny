package com.example.demo1.Customer;

interface Balance {
    long withdrawal(long balance, long withdrawalAmount) throws Exception;
    long deposit(long balance, long depositAmount) throws Exception;
}


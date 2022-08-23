package com.example.demo.customer;

@SuppressWarnings("unused")
interface Balance {
    long withdrawal(long balance, long withdrawalAmount) throws Exception;
    long deposit(long balance, long depositAmount) throws Exception;
}


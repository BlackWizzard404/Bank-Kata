package org.account.service.dto;

import java.util.Date;

public class TransactionDto {
    private int amount;
    private Date date;

    private int balance;

    public TransactionDto(int amount, Date date,int balance) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}

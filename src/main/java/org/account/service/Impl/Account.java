package org.account.service.Impl;

import org.account.service.AccountService;
import org.account.service.dto.TransactionDto;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account implements AccountService {
    private final List<TransactionDto> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        // Method intentionally left blank
    }

    @Override
    public void withdraw(int amount) {
        // Method intentionally left blank
    }

    public void deposit(int amount, Date date) {
        balance+= amount;
        transactions.add(new TransactionDto(amount, date, balance));
    }

    public void withdraw(int amount, Date date) {
        balance -= amount;
        transactions.add(new TransactionDto(-amount, date,balance));
    }

    @Override
    public void printStatement() {

        System.out.println("Date || Amount || Balance");
        Collections.reverse(transactions);
        for (TransactionDto transaction : transactions) {
            System.out.println(formatDate(transaction.getDate()) + " || " + transaction.getAmount() + " || " + transaction.getBalance());
        }
    }
    public String getPrintStatement() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Date       || Amount || Balance").append("\n");

        for (int i = 0; i < transactions.size(); i++) {
            TransactionDto transaction = transactions.get(i);
            stringBuilder.append(formatDate(transaction.getDate()))
                    .append(" || ")
                    .append(transaction.getAmount())
                    .append("   || ")
                    .append(transaction.getBalance());

            if (i < transactions.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }
}



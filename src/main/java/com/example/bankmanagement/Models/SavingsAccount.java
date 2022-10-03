package com.example.bankmanagement.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class SavingsAccount extends Account{
    private final DoubleProperty withdrawalLimit;


    public SavingsAccount(String owner, String accountNumber, double balance ,double wLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this,"Withdrawal Limit",wLimit);
    }

    public DoubleProperty withdrawalLimitProop() {return this.withdrawalLimit;}
}

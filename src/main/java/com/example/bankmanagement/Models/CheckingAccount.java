package com.example.bankmanagement.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account{

    private final IntegerProperty trasanctionLimit;


    public CheckingAccount(String owner, String accountNumber, double balance ,int tLimit) {
        super(owner, accountNumber, balance);
        this.trasanctionLimit = new SimpleIntegerProperty(this,"Transaction Limit",tLimit);
    }

    public IntegerProperty TrasanctionLimitProop() {return this.trasanctionLimit;}
}

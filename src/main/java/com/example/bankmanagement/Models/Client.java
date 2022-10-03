package com.example.bankmanagement.Models;




import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client  {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingsAccount;
    private final ObjectProperty<LocalDate> dateCreated;



    public Client(String fName, String lName, String pAddress, Account cAccount, Account sAccount, LocalDate date )
    {
        this.firstName = new SimpleStringProperty(this,"FirstName",fName);
        this.lastName = new SimpleStringProperty(this,"LastName",lName);
        this.payeeAddress = new SimpleStringProperty(this,"PayeeAddress",pAddress);
        this.checkingAccount = new SimpleObjectProperty<Account>(this, "CheckingAccount", cAccount);
        this.savingsAccount= new SimpleObjectProperty<Account>(this,"SavingsAccount",sAccount);
        this.dateCreated = new SimpleObjectProperty<LocalDate>(this,"Date",date);
    }

    public StringProperty firstNameProperty() {return this.firstName;}
    public StringProperty lastNameProperty() {return this.lastName;}
    public StringProperty pAddress() {return this.payeeAddress;}
    public ObjectProperty<Account> checkingAccountProperty() {return this.checkingAccount;}
    public ObjectProperty<Account> savingsAccountProperty() {return this.savingsAccount;}
    public ObjectProperty<LocalDate> dateProperty() {return this.dateCreated;}




}

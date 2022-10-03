package com.example.bankmanagement.Models;

import com.example.bankmanagement.Views.AccountType;
import com.example.bankmanagement.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final Client client;

    private final DatabaseDriver databaseDriver;
    private AccountType loginAccountType = AccountType.CLIENT;
    private boolean clientLoginSuccessFlag;




    public Client getClient(){
        return client;
    }

    private  Model(){ //DatabaseDriver databaseDriver
        this.databaseDriver = new DatabaseDriver();
        this.viewFactory = new ViewFactory();

        this.clientLoginSuccessFlag = false;
        this.client = new Client("","","",null,null,null);
    }

    public static synchronized Model getInstance(){

        if(model== null)
        {
           model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver(){
        return databaseDriver;
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public boolean getClientLoginSuccessFlag()
    {
        return this.clientLoginSuccessFlag;
    }
    public void setClientLoginSuccessFlag(boolean flag){
       this.clientLoginSuccessFlag =flag;
    }


    public void evaluateClientCred(String address, String password) {

        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;

        ResultSet resultSet = databaseDriver.getClientData(address, password);

        try{
            if(resultSet.isBeforeFirst())
            {
                this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                this.client.lastNameProperty().set(resultSet.getString("LastName"));
                this.client.pAddress().set(resultSet.getString("PayeeAddress"));
                String[] dateParts= resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateProperty().set(date);
                /*checkingAccount =null;
                savingsAccount =null; */
                this.clientLoginSuccessFlag =true;
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }



    /** Client sectiom **/




}

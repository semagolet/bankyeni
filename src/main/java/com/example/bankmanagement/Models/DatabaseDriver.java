package com.example.bankmanagement.Models;

import java.sql.*;

public class DatabaseDriver {

    private Connection conn;

    public DatabaseDriver(){
        try{
            this.conn= DriverManager.getConnection("jdbc:sqlite:bank.db");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }


    }

    public ResultSet getClientData(String pAddress,String password)
    {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("Selecet * FROM Clients Where PayeeAddress =' " + pAddress + "' AND Password='" + password + "';");
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;















    }
}

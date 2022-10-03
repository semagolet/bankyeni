package com.example.bankmanagement.Controllers.Client;

import com.example.bankmanagement.Models.Model;
import com.example.bankmanagement.Views.AdminMenuOptions;
import com.example.bankmanagement.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners(){
            dashboard_btn.setOnAction(actionEvent -> onDashboard());
            transaction_btn.setOnAction(actionEvent -> onTransactions());
            accounts_btn.setOnAction(actionEvent -> onAccounts());
        }


    private void onDashboard() {

        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARDS);
    }

    private void onTransactions(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }


}

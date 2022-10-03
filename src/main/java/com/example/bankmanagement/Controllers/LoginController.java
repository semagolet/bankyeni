package com.example.bankmanagement.Controllers;

import com.example.bankmanagement.Models.Model;
import com.example.bankmanagement.Views.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_selector;
    public Label payee_address_lbl;
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.setItems(FXCollections.observableArrayList(AccountType.CLIENT,AccountType.ADMIN));
        acc_selector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_selector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_selector.getValue()));
       // login_btn.setOnAction(actionEvent -> Model.getInstance().getViewFactory().showClientWindow());
        login_btn.setOnAction(event -> onLogin());
    }

    private void onLogin(){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
       // Model.getInstance().getViewFactory().closeStage(stage);
        //Model.getInstance().getViewFactory().showClientWindow();

        if(Model.getInstance().getViewFactory().getLoginAccountType()==AccountType.CLIENT)
        {
           // Model.getInstance().getViewFactory().showClientWindow();
            Model.getInstance().evaluateClientCred(payee_address_fld.getText(),password_fld.getText());
            if(Model.getInstance().getClientLoginSuccessFlag())
            {
                Model.getInstance().getViewFactory().showClientWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }else{
                payee_address_fld.setText("");
                password_fld.setText("");
                error_lbl.setText("No such login credentials");
            }

        }
        else {
            Model.getInstance().getViewFactory().showAdminWindow();
        }

    }
}

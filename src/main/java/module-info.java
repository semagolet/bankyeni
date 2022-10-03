module com.example.bankmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;



    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.bankmanagement to javafx.fxml;
    exports com.example.bankmanagement;
    exports com.example.bankmanagement.Controllers;
    exports com.example.bankmanagement.Controllers.Admin;
    exports com.example.bankmanagement.Controllers.Client;
    exports com.example.bankmanagement.Models;
    exports com.example.bankmanagement.Views;

}
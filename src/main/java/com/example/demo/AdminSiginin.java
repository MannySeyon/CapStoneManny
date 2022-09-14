package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminSiginin {
    public Button loginButton;
    @FXML
    private TextField employee_id;
    @FXML
    private TextField password;
    @FXML
    private Label passwordShow;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainModified.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void Login(ActionEvent event) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select count(1) from  admins where     username = ? and password = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, employee_id.getText());
        statement.setString(2, password.getText());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            if (resultSet.getInt(1) == 1) {


                FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDash.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                passwordShow.setText("Wrong Employee id and password combination!");
            }

        }

    }
}

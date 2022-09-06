package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



    public class PasswordRecoveryController {
        @FXML
        public Button loginButton;
        @FXML
        private TextField ssn;
        @FXML
        private TextField email;
        @FXML
        private TextField username;





        public void VerifyCoustmer(ActionEvent Event) throws SQLException {
            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection();
            String query = "select ssn from  customer_personal_info where username = ?   and email= ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,username.getText());
            statement.setString(2,email.getText());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int datassn = resultSet.getInt(1);
                int k=0;
                char [] social = new char[5];
                for (int i = 4; i < 9; i++) {
                    social[k]= String.valueOf(datassn).charAt(i);
                    k++;
                }
                String  compssn= new String(social);
                System.out.println(compssn);
                if(compssn.equals(ssn.getText())){
                    System.out.println("your account is  in our data base");
                }else {
                    System.out.println("your account is not in our data base");
                }
            }

        }
    }



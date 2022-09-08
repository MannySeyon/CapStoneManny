package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateTimeStringConverter;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

@SuppressWarnings("ALL")
public class ClientLoginController {
    @FXML
    private Label phoneLabel, emailLabel, UserLabel, passwordLabel, welcomeLabel, passwordShow, TimeDateLabel;
    @FXML
    ImageView BanklogoGif;
    @FXML TextField nameTextField;  @FXML private PasswordField passwordField;
    @FXML
    private Button Home, SignupButton, loginButton;
    @FXML
    private AnchorPane anchorPane;
    private Stage stage; private Scene scene; private Parent root;
    @FXML
    private String username,password;
    @FXML
    protected void SignUpPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void passwordRecovery(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("PasswordRecovery.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Home(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void AdminDash(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("AdminSignin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxml);
        stage.setScene(scene);
        stage.show();
    }
@SuppressWarnings("ThrowablePrintedToSystemOut")
@FXML
    public void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {
        if(nameTextField.getText().isBlank()==false && passwordField.getText().isBlank()==false){
            validateLogin(event);
        }
        else {
             passwordShow.setText("Please enter User name and Password");
        }
    }
@FXML
    public void validateLogin(ActionEvent event ) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select count(1) from  customer_personal_info where     username = ? and password = ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,nameTextField.getText());
        statement.setString(2,passwordField.getText());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1));
            if (resultSet.getInt(1) == 1) {

                DashBoardController dashBoardController= new DashBoardController();
                dashBoardController.getInfo(nameTextField.getText(),passwordField.getText());

                FXMLLoader loader = new FXMLLoader(getClass().getResource("LandingPage.fxml"));
                root = loader.load();
                DashBoardController landingController = loader.getController();
                    landingController.displayName(nameTextField.getText(),passwordField.getText());
                landingController.showTime();
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                passwordShow.setText("Wrong user name and password combination!");
            }
        }
    }
}

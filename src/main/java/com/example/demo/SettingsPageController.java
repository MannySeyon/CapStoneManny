package com.example.demo;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SettingsPageController   {

    public BarChart chart;
    public TableView TransactionTable;
    @FXML
    private Button userProfileButton;
    @FXML
    private  Label dateandTime2;
    @FXML
    private  Label GenerateReportLabel;
    @FXML
   private Label firstNameLabel, middleNameLabel, lastNameLabel, ssnLabel, DOBLabel,
           phoneNumberLabel, emailLabel, streetNameLabel, cityLabel, zipCodeLabel, aptLabel,
           maritalStatusLabel, genderLabel, usernameLabel, passwordLabel, dashLabel, nameLabel;
    @FXML
    private TextField firstNameTF,middleNameTF, lastNameTF, ssnTF, phoneNumberTF, emailTF,
            cityTF, streetTF, zipCodeTF,apartmentTF,UsernameF, PasswordF;
    @FXML
    private  DatePicker datePicker;
    @FXML
    private ToggleGroup maritaltoggle;
    @FXML
    private  ToggleGroup gendertoggle;
    @FXML
   private BorderPane SettingPageBorder;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private ImageView securityLogo;
    @FXML
    private Button homeButton, SettingButton, TransactionButton;
    @FXML
    private FontAwesomeIconView HomeButton, bars;
    String nameUser, password;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void Home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Settings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SettingsPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void Transactions(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TransactionPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void getInfo (String password,String nameUser){
        this.password=password;
        this.nameUser =nameUser;
    }
    public String setUser(String user){
        return user;
    }
    @FXML
    protected void Logout(ActionEvent event) throws IOException {
        //Logout Alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You Are About To Logout");
        alert.setContentText("Do you want to Logout?");

        //If they click ok-logout-return to the login screen
        if(alert.showAndWait().get() == ButtonType.OK) {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    //Save any progress and close stage
    @FXML
    public void Exit(ActionEvent event) {
        //Create Alert box-Confirmation type
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You Are About To Quit");
        alert.setContentText("Do you want to Quit?");
        if(alert.showAndWait().get() == ButtonType.OK) {
            //set stage =to the current working stage
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("You've successfully Quit!");
            stage.close();
        }
    }
}

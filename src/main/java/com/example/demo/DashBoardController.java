package com.example.demo;

import com.example.demo.customer.Customer;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


@SuppressWarnings("ALL")
public class DashBoardController  {
    @FXML
    private Circle circle;

    @FXML
    private BarChart<String, Double> chart;
    @FXML
    private BorderPane LandingPageBorder;
    @FXML
    private Label userNameCard2, card2Number, balanceLabelCard2, VisaLabelCard2m, card1Number,
            balanceLabelCard1, userNameCard1, VisaLabelCard1, TimeDateLabel, cardLabel1, dashLabel, nameLabel
            , VisaLabelCard2, savingsBalance, Savingslabel, checkingsBalance,savingsBalance1;
    String nameUser, password;
    public AnchorPane goldColoredCard, blueColoredCard, anchorPane, pane2;
    public Button card1PlusButton, exit, Home, Logout, homeButton;
    @FXML
    private  FontAwesomeIconView bars, HomeButton, list, image, gear,plus;
    @FXML
    private ImageView securityLogo, bankLogo;
    @FXML
    private  Separator separator;
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


    public void showTime() {
        TimeDateLabel.setText(String.valueOf(LocalDateTime.now()));
    }
    public void showBalance (String nameUser,String password) throws SQLException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query= "call checking_balance(?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,nameUser);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            checkingsBalance.setText("$"+resultSet.getString(1));
            Integer dataBalance = resultSet.getInt(2);

            String lengthDataBalance=dataBalance.toString();
            int k=0;
            char [] checkingBalance = new char[4];
            for (int i = lengthDataBalance.length()-4; i < lengthDataBalance.length(); i++) {
                checkingBalance[k]= String.valueOf(dataBalance).charAt(i);
                k++;
            }
            card1Number.setText("****  ****  ****  "+String.valueOf(checkingBalance));
    }
        String query2= "call saving_balance(?,?)";
        PreparedStatement statement2 = connection.prepareStatement(query2);
        statement2.setString(1,nameUser);
        statement2.setString(2,password);
        ResultSet resultSet2 = statement2.executeQuery();

        while(resultSet2.next()){
            savingsBalance.setText("$"+resultSet2.getString(1));
            savingsBalance1.setText("$"+resultSet2.getString(1));
            Integer dataBalance = resultSet2.getInt(2);
            String lengthDataBalance=dataBalance.toString();
            int k=0;
            char [] savingBalance = new char[4];
            for (int i = lengthDataBalance.length()-4; i < lengthDataBalance.length(); i++) {
                savingBalance[k]= String.valueOf(dataBalance).charAt(i);
                k++;
            }
            card2Number.setText("****  ****  ****  "+String.valueOf(savingBalance));
        }
    }

    public void displayName(String nameUser,String password) throws SQLException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select First_name,Last_name from  customer_personal_info where username = ?   and password= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,nameUser);
        statement.setString(2,password);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(password);
        while(resultSet.next()){
            nameLabel.setText("Hello, " + resultSet.getString(1) +" "+ resultSet.getString(2)  + ". Welcome to your Summit Dashboard!" );

        }

    }
}


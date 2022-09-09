
package com.example.demo;

        import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
        import javafx.animation.TranslateTransition;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.chart.BarChart;
        import javafx.scene.control.*;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.io.IOException;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.time.LocalDateTime;
        import java.util.ResourceBundle;

public class TransactionPageController implements Initializable {


    @FXML
    private  Button statementPageButton, graphView, tableView, homeButton, SettingButton, TransactionButton;
    @FXML
    private TableView TransactionTable;
    @FXML private ImageView securityLogo;
    @FXML
    private BorderPane TransactionBorder;
    @FXML private AnchorPane anchorPane;
    @FXML
    private BarChart chart;
    @FXML
    private Label nameLabel, TimeDateLabel, dashLabel, GenerateReportLabel;
    @FXML
    private FontAwesomeIconView HomeButton, bars;
    String nameUser, password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private VBox vbox;
    @FXML
    private Parent fxml;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Translation();
    }

    @FXML
    private void Open_Table(ActionEvent event) {
        Translation();
    }

    private void Translation() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vbox);
        transition.setToX(vbox.getLayoutX() * 20);
        transition.play();
        transition.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("TransactionTable.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }

    @FXML
    private void Open_Graph(ActionEvent event) {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1), vbox);
        transition.setToX(0);
        transition.play();
        transition.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("TransactionGraph.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {

            }
        });
    }
    public void getInfo(String password, String nameUser) {
        this.password = password;
        this.nameUser = nameUser;
    }

    public String setUser(String user) {
        return user;
    }

    public void showTime() {
        TimeDateLabel.setText(String.valueOf(LocalDateTime.now()));
        TimeDateLabel.setText(String.valueOf(LocalDateTime.now()));
    }

    public void displayName(String nameUser, String password) throws SQLException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "select First_name,Last_name from  customer_personal_info where username = ?   and password= ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, nameUser);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(password);
        while (resultSet.next()) {
            nameLabel.setText("Hello, " + resultSet.getString(1) + " " + resultSet.getString(2) + ". Welcome to your Summit Dashboard!");

        }
    }
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
        root = FXMLLoader.load(getClass().getResource("LandingPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    protected void Logout(ActionEvent event) throws IOException {
        //Logout Alert
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You Are About To Logout");
        alert.setContentText("Do you want to Logout?");

        //If they click ok-logout-return to the login screen
        if (alert.showAndWait().get() == ButtonType.OK) {
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
        if (alert.showAndWait().get() == ButtonType.OK) {
            //set stage =to the current working stage
            stage = (Stage) anchorPane.getScene().getWindow();
            System.out.println("You've successfully Quit!");
            stage.close();
        }
    }

}
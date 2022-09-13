
package com.example.demo;

        import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
        import javafx.animation.TranslateTransition;
        import javafx.beans.value.ObservableValue;
        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.chart.BarChart;
        import javafx.scene.control.*;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.VBox;
        import javafx.stage.Stage;
        import javafx.util.Callback;
        import javafx.util.Duration;

        import java.io.IOException;
        import java.net.URL;
        import java.sql.*;
        import java.time.LocalDateTime;
        import java.util.Locale;
        import java.util.ResourceBundle;

public class TransactionPageController {

    @FXML
    private Button statementPageButton, graphView, tableView, homeButton, SettingButton, TransactionButton;
    @FXML
    private TableView<?> TransactionTable;
    @FXML
    private ImageView securityLogo;
    @FXML
    private AnchorPane anchorPane, pane2;
    @FXML
    private BorderPane TransactionBorder;
    @FXML
    private BarChart chart;
    @FXML
    private Label nameLabel, TimeDateLabel, dashLabel, GenerateReportLabel, dateandTime2;
    @FXML
    private FontAwesomeIconView HomeButton, bars;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<?, ?> dateColumn;
    @FXML
    private TableColumn<?, ?> transactionColumn;
    @FXML
    private TableColumn<?, ?> typeColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private TableColumn<?, ?> balanceColumn;
    private PreparedStatement pst = null;
    private Connection con = null;
    private ResultSet rs = null;

    private Date Date_Created, income_Date, expenses_date;
    private String expenses_supplier, typeTable, transactionTable;
    private float income_amount, income_deposite_in_bank, expresses_amount;


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
    protected void TransactionsTable(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TransactionTable.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void TransactionsGraph(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TransactionGraph.fxml"));
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


    public void transactionQuery() throws SQLException, IOException{
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "call Transaction(?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement((query));
        statement.setDate(1, Date_Created);
        statement.setDate(2, income_Date);
        statement.setFloat(3, income_amount);
        statement.setDate(4, expenses_date);
        statement.setString(5, expenses_supplier);
        statement.setFloat(6, expresses_amount);
        System.out.println();
        ResultSet rs = statement.executeQuery();

    }

    public class transactionMethod {
        Date dateTable;
        public Date getDateTable() {
            return dateTable;
        }
        public void setDateTable(Date dateTable) {
            this.dateTable = dateTable;
        }
        public String getTransactionTable() {
            return transactionTable;
        }
        public void setTransactionTable(String transactionTable) {
            this.transactionTable = transactionTable;
        }
        public String getTypeTable() {
            return typeTable;
        }
        public void setTypeTable(String typeTable) {
            this.typeTable = typeTable;
        }
        public float getPriceTable() {
            return priceTable;
        }
        public void setPriceTable(float priceTable) {
            this.priceTable = priceTable;
        }
        public float getCurrentBalance() {
            return currentBalance;
        }
        public void setCurrentBalance(float currentBalance) {
            this.currentBalance = currentBalance;
        }
        private String transactionTable;
        private String typeTable;
        private float priceTable;
        float currentBalance;

        public transactionMethod(Date dateTable, String transactionTable, String typeTable, float priceTable, float currentBalance) {
            this.dateTable = dateTable;
            this.transactionTable = transactionTable;
            this.typeTable = typeTable;
            this.priceTable = priceTable;
            this.currentBalance = currentBalance;
        }

        public void initialize(URL url, ResourceBundle rb){
            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection();
        }

        public void setCellTable(){

            dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateTable"));
            transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transationTable"));
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("typeTable"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("priceTable"));
            balanceColumn.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));



        }


    }

}
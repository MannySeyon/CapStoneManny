package com.example.demo.Admin;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {
    //First Pane create clients
    @FXML
    public TextField FName_fld;
    @FXML
    public TextField MName_fld;
    @FXML
    public TextField Ssn_fld;
    @FXML
    public TextField LName_fld;
    @FXML
    public TextField Phone_no_fld;
    @FXML
    public DatePicker DOB_fld;
    @FXML
    public RadioButton Single_radio_btn;
    @FXML
    public RadioButton Married_radio_btn;
    @FXML
    public RadioButton Male_radio_btn;
    @FXML
    public RadioButton Female_radio_btn;
    @FXML
    public RadioButton Non_binary_radio_btn;
    //Second Pane clients listview
    @FXML
    public TextField email_fld;
    @FXML
    public TextField Address_fld;
    @FXML
    public TextField city_fld;
    @FXML
    public TextField zipcode_fld;
    @FXML
    public TextField username_fld;
    @FXML
    public TextField password_fld;
    @FXML
    public CheckBox ck_acc_cb;
    @FXML
    public CheckBox sv_acc_cb;
    @FXML
    public TextField ck_acc_bal_fld;
    @FXML
    public TextField sv_acc_bal_fld;
    @FXML
    public Button Create_new_btn;
    @FXML
    public ChoiceBox state_fld;

    //Third Pane clients deposit
    @FXML
    public TextField rusername_fld;
    @FXML
    public Button search_btn;
    @FXML
    public ListView result_listview;
    @FXML
    public TextField ck_amount_fld;
    @FXML
    public Button ck_deposit_btn;
    @FXML
    public TextField sv_amount_fld;
    @FXML
    public Button sv_deposit_btn;
    @FXML
    public TextField search_database_fld;
    @FXML
    public Button Search_Client_btn;
    @FXML
    public TextField raddress_fld;
    @FXML
    private SplitPane pnCreateClient;
    @FXML
    private Pane pnClientsListview;
    @FXML
    private AnchorPane pnDeposits;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button create_c_btn, Clients_btn, deposit_btn, logout_btn;
// table data clients view
    @FXML
    private TableView<ConnTable> table;
    @FXML
    private TableColumn<ConnTable, String> col_accnum;
    @FXML
    private TableColumn<ConnTable, String> col_fname;
    @FXML
    private TableColumn<ConnTable, String> col_lname;
    @FXML
    private TableColumn<ConnTable, String> col_mname;
    @FXML
    private TableColumn<ConnTable, String> col_dob;
    @FXML
    private TableColumn<ConnTable, String> col_address;
    @FXML
    private TableColumn<ConnTable, String> col_zip;
    @FXML
    private TableColumn<ConnTable, String> col_state;
    @FXML
    private TableColumn<ConnTable, String> col_country;
    @FXML
    private TableColumn<ConnTable, String> col_city;
    @FXML
    private TableColumn <ConnTable, String>col_contactnum;
    @FXML
    private TableColumn<ConnTable, String> col_last4ssn;
    @FXML
    private TableColumn<ConnTable, String> col_username;
    @FXML
    private TableColumn<ConnTable, String> col_email;

    ObservableList<ConnTable>clientsList = FXCollections.observableArrayList();



    @FXML
    private void handleClicks(ActionEvent event) {

        if (event.getSource() == create_c_btn) {
            pnCreateClient.toFront();

        } else if (event.getSource() == Clients_btn) {
            pnClientsListview.toFront();
        } else if (event.getSource() == deposit_btn) {
            pnDeposits.toFront();
        }
    }

    @FXML
    private void createClientActions(ActionEvent event) {

    }
    @FXML
    protected void ClientListActions(ActionEvent actionEvent) {
    }
    @FXML
    protected void depositActions(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://34.68.83.162/bs_db1", "root", "1558");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            ResultSet rs = con.createStatement().executeQuery("select * from customer_personal_info ");
            while (rs.next()) {
                clientsList.add(new ConnTable(rs.getString("Account_number"),rs.getString("First_name"), rs.getString("Last_name"),rs.getString("Middle_name"),rs.getString("date_of_birth"),rs.getString("address"),rs.getString("zipp_code"),rs.getString("state"),rs.getString("Country"),rs.getString("city"),rs.getString("contact_no"),rs.getString( "ssn"),rs.getString( "username"),rs.getString( "email")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        col_accnum.setCellValueFactory(new PropertyValueFactory<>("Account_number"));
        col_fname.setCellValueFactory(new PropertyValueFactory<>("First_name"));
        col_lname.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        col_mname.setCellValueFactory(new PropertyValueFactory<>("Middle_name"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_zip.setCellValueFactory(new PropertyValueFactory<>("zipp_code"));
        col_state.setCellValueFactory(new PropertyValueFactory<>("state"));
        col_country.setCellValueFactory(new PropertyValueFactory<>("Country"));
        col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        col_contactnum.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        col_last4ssn.setCellValueFactory(new PropertyValueFactory<>("ssn"));
        col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.setItems(clientsList);
    }
}
package com.example.demo.Admin;


import com.example.demo.Connectivity;
import com.example.demo.customer.Customer;
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

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AdminDashController implements Initializable {
    //First splitPane create clients
    @FXML
    private TextField FName_fld;
    @FXML
    private TextField MName_fld;
    @FXML
    private TextField Ssn_fld;
    @FXML
    private TextField LName_fld;
    @FXML
    private TextField Phone_no_fld;
    @FXML
    private DatePicker DOB_fld;
    @FXML
    private RadioButton Single_radio_btn;
    @FXML
    private RadioButton Married_radio_btn;
    @FXML
    private RadioButton Male_radio_btn;
    @FXML
    private RadioButton Female_radio_btn;
    @FXML
    private RadioButton Non_binary_radio_btn;
    //Second splitPane clients listview
    @FXML
    private TextField email_fld;
    @FXML
    private TextField Address_fld;
    @FXML
    private TextField city_fld;
    @FXML
    private TextField zipcode_fld;
    @FXML
    private TextField username_fld;
    @FXML
    private TextField password_fld;
    @FXML
    private CheckBox ck_acc_cb;
    @FXML
    private CheckBox sv_acc_cb;
    @FXML
    private TextField ck_acc_bal_fld;
    @FXML
    private TextField sv_acc_bal_fld;
    @FXML
    private Button Create_new_btn;
    @FXML
    private ChoiceBox state_fld;

    //Third Pane clients deposit
    @FXML
    private TextField rusername_fld;
    @FXML
    private Button search_btn;
    @FXML
    private TextField ck_amount_fld;
    @FXML
    private Button ck_deposit_btn;
    @FXML
    private TextField sv_amount_fld;
    @FXML
    private Button sv_deposit_btn;
    @FXML
    private TextField search_database_fld;
    @FXML
    private Button Search_Client_btn;
    @FXML
    private TextField raddress_fld;
    @FXML
    private Button Delete_btn;
    //Transaction table
    @FXML
    private TableView Transaction_table;
    @FXML
    private TableColumn col_Transaction_Number;
    @FXML
    private TableColumn col_Account_Number;
    @FXML
    private TableColumn col_Date_created;
    @FXML
    private TableColumn col_income_date;
    @FXML
    private TableColumn col_income_deposit;
    @FXML
    private TableColumn col_income_amount;
    @FXML
    private TableColumn col_expense_date;
    @FXML
    private TableColumn col_expense_supplier;
    @FXML
    private TableColumn col_expense_amount;
    //Checking table
    @FXML
    private TableView Checking_table;
    @FXML
    private TableColumn col_checking_acc_number;
    @FXML
    private TableColumn col_account_number;
    @FXML
    private TableColumn col_account_balance;
    @FXML
    private TextField ck_amount_deposit_fld;
    @FXML
    private Button ck_amount_deposit_btn;
    //Savings table
    @FXML
    private TableView Savings_table;
    @FXML
    private TableColumn col_saving_acc_number;
    @FXML
    private TableColumn col_acc_number;
    @FXML
    private TableColumn col_acc_bal;
    @FXML
    private TextField sv_amount_deposit_fld;
    @FXML
    private Button sv_amount_deposit_btn;
    @FXML
    private TextField Apartment_fld;
    private TextField search_db_fld;


    // sets option choices
    @FXML
    private String maritalSet = "";
    @FXML
    private String genderSet = "";

    @FXML
    private Label verifyPhoneLabel;
    @FXML
    private Label verifySSNLabel;
    @FXML
    private Label verifyAgeLabel;
    @FXML
    private Label genderLabel;

    @FXML
    private Button Update_btn;
    @FXML
    private ComboBox<String> state_ComboBox;
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
    ObservableList<String> stateList = FXCollections.observableArrayList(
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming");



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
  public boolean CheckDate(){
        if (DOB_fld.getValue()==null){
            return false;
        }
        return true;
    }

    public void verify(ActionEvent actionEvent) throws Exception {

        String[] verifyTextfield = new String[]{FName_fld.getText(), LName_fld.getText(), Ssn_fld.getText(),
                username_fld.getText(), password_fld.getText(), Phone_no_fld.getText(), email_fld.getText(), Address_fld.getText(), city_fld.getText(), zipcode_fld.getText(), MName_fld.getText()};

        TextField[] textFields = new TextField[]{FName_fld, LName_fld, Ssn_fld, username_fld, password_fld, Phone_no_fld, email_fld, Address_fld, city_fld, zipcode_fld, MName_fld};

        if(CheckDate()==false) {
            DOB_fld.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
        }


        for (int i = 0; i < verifyTextfield.length; i++) {
            if (verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            } else if (!verifyTextfield[i].isBlank()) {
                textFields[i].setStyle("-fx-text-box-border: #D3D3D3; -fx-focus-color: #D3D3D3;");
            }
        }
        if (Ssn_fld.getText().length() != 9 || Phone_no_fld.getText().length() != 10 || checkSSNInfo() == false || checkPhoneInfo() == false || ageVerify() == false) {

            if (Ssn_fld.getText().length() != 9 || checkSSNInfo() == false) {
                Ssn_fld.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifySSNLabel.setText("Your Social Security Number is invalid.");
            } else {
                verifySSNLabel.setText("");
            }

            if (checkPhoneInfo() == false || Phone_no_fld.getText().length() != 10) {
                Phone_no_fld
                        .setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifyPhoneLabel.setText("Your phone number is invalid.");
            } else {
                verifyPhoneLabel.setText("");
            }
            if (ageVerify() == false) {
                DOB_fld.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
                verifyAgeLabel.setText("You are not eligable to create an account");
            } else {
                verifyAgeLabel.setText("");
            }
            if(!Male_radio_btn.isSelected() || !Female_radio_btn.isSelected() || !Non_binary_radio_btn.isSelected()){
                genderLabel.setStyle("-fx-text-box-border: #ff0000; -fx-focus-color: #ff0000;");
            }

        } else {
            verifySSNLabel.setText("");
            verifyPhoneLabel.setText("");
            verifyAgeLabel.setText("");
            saveInfo(actionEvent);
        }
    }

    //Methods that checks for age ; ssn & phone = number ; if user exists
    public boolean checkSSNInfo() throws Exception, ArithmeticException {

        try {
            int intValue = Integer.parseInt(Ssn_fld.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkPhoneInfo() throws Exception, ArithmeticException {

        try {
            int intValue = Integer.parseInt(Phone_no_fld.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public boolean ageVerify() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(DOB_fld.getValue().getYear(),
                DOB_fld.getValue().getMonth(),
                DOB_fld.getValue().getDayOfMonth());
        LocalDate verifyAge = today.minusYears(birthday.getYear());
        if (verifyAge.getYear() < 16) {
            return false;
        } else if (verifyAge.getYear() == 16 && today.getMonthValue() < birthday.getMonthValue()) {
            return false;
        } else if (verifyAge.getYear() == 16 && today.getMonthValue() == birthday.getMonthValue() && today.getDayOfMonth() < birthday.getDayOfMonth()) {
            return false;
        } else {
            return true;
        }
    }


    public String genderCheck() {

        if (Male_radio_btn.isSelected()) {
            genderSet = "M";
        } else if (Female_radio_btn.isSelected()) {
            genderSet = "F";

        } else if (Non_binary_radio_btn.isSelected()) {
            genderSet = "O";
        }
        return genderSet;
    }

    public String maritalCheck() {

        if (Single_radio_btn.isSelected()) {
            maritalSet = "single";
        } else if (Married_radio_btn.isSelected()) {
            maritalSet = "married";
        }
        return maritalSet;
    }


    //Method that saves information from user input
    public void saveInfo(ActionEvent actionEvent) throws SQLException, IOException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        Customer customer = new Customer(FName_fld.getText(),
                LName_fld.getText(),
                MName_fld.getText(),
                LocalDate.of(DOB_fld.getValue().getYear(),
                        DOB_fld.getValue().getMonth(),
                        DOB_fld.getValue().getDayOfMonth()),
                Ssn_fld.getText(),
                Phone_no_fld.getText(),
                email_fld.getText(),
                username_fld.getText(),
                password_fld.getText(),
                Address_fld.getText(),
                city_fld.getText(),
                state_ComboBox.getValue(),
                zipcode_fld.getText(),
                Apartment_fld.getText(),genderCheck(), maritalCheck()
        );
        System.out.println("You have successfully added " + customer);

        String query = "insert into customer_personal_info(" + "First_name,Last_name,middle_name,date_of_birth,address,zipp_code,Country,states,city,contact_no, ssn,username,password,email,gender,marital_status) values "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getMiddleName());
        statement.setString(4, customer.getDateOfBirth().toString());
        statement.setString(5, customer.getStreet());
        statement.setString(6, customer.getZipCode());
        statement.setString(7, "US");
        statement.setString(8, customer.getState());
        statement.setString(9, customer.getCity());
        statement.setString(10, customer.getPhoneNumber());
        statement.setString(11, customer.getSSN());
        statement.setString(12, customer.getUsername());
        statement.setString(13, customer.getPassword());
        statement.setString(14, customer.getEmail());
        statement.setString(15, customer.getGender());
        statement.setString(16, customer.getMartialStatus());
        statement.executeUpdate();
        System.out.println(customer.getEmail());
        connection.close();
    }

    public void CheckIfUserExists() throws SQLException {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();
        String query = "SELECT * FROM customer_personal_info WHERE ssn = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, Ssn_fld.getText());
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {

        }
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
        state_ComboBox.setItems(stateList);

    }

}
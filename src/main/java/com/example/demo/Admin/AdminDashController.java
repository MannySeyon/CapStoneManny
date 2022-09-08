package com.example.demo.Admin;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.net.URL;
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
    private SplitPane pnCreateClient;
    @FXML
    private Pane pnClientsListview;
    @FXML
    private AnchorPane pnDeposits;
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button create_c_btn, Clients_btn, deposit_btn, logout_btn;



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

    }
}
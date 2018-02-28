package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {

    @FXML
    private Text userIdText;
    @FXML
    private Text firstNameText;
    @FXML
    private Text secondNameText;
    @FXML
    private Text roleText;
    @FXML
    private Text userTypeText;
    @FXML
    private TextField mobileNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordOne;
    @FXML
    private PasswordField passwordTwo;

    @Override
    public void initialize(URL url, ResourceBundle rb){

        userIdText.setText(Integer.toString(Session.userSession.getUserId()));
        setFields();
    }

    private void setFields(){
        firstNameText.setText(Session.userSession.getfName());
        secondNameText.setText(Session.userSession.getsName());
        roleText.setText(Session.userSession.getRole());
        userTypeText.setText(Session.userSession.getUserType());
        mobileNumberTextField.setText(Session.userSession.getMobileNo());
        emailTextField.setText(Session.userSession.getEmail());
        passwordOne.setText(Session.userSession.getPassword());
        passwordTwo.setText(Session.userSession.getPassword());
    }
}

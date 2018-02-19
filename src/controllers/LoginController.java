package controllers;

import functionality.ClientServerConnection;
import functionality.LoginRequest;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    private String username;
    private String password;
    private LoginRequest loginRequest;
    private ClientServerConnection clientServerConnection;

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;

    @FXML
    public void getLoginDetails(){

        clientServerConnection = new ClientServerConnection();

        username = usernameTextField.getText();
        password = passwordTextField.getText();

        loginRequest = new LoginRequest(username, password);
        System.out.println("Sending Login Request");
        clientServerConnection.startClientLoginRequest(loginRequest);


    }



}

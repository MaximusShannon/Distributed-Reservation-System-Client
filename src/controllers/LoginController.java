package controllers;

import functionality.ClientServerConnection;
import functionality.LoginRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Session;
import models.User;

public class LoginController {

    private String username;
    private String password;
    private LoginRequest loginRequest;
    private ClientServerConnection clientServerConnection;


    @FXML
    private Pane loginStage;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Button openRegistrationButton;

    @FXML
    public void getLoginDetails(){

        User authenticatedUser;

        clientServerConnection = new ClientServerConnection();

        username = usernameTextField.getText();
        password = passwordTextField.getText();

        loginRequest = new LoginRequest(username, password);
        System.out.println("Sending Login Request");
        authenticatedUser = clientServerConnection.startClientLoginRequest(loginRequest);

        if(authenticatedUser != null){
            Session.userSession = authenticatedUser;
            openMainMenu();
            closeStage();
        }
    }

    private void openMainMenu(){
        try{
            Stage mainMenuStage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("../view/mainmenu.fxml"));
            mainMenuStage.setTitle("Hello World");
            mainMenuStage.setScene(new Scene(root, 1200, 800));
            mainMenuStage.show();
            closeStage();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void openRegistrationStage(){

        try{
            Stage registerStage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("../view/registerview.fxml"));
            registerStage.setTitle("Hello World");
            registerStage.setScene(new Scene(root, 900, 500));
            registerStage.show();
            closeStage();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeStage(){

        Stage stage = (Stage) loginStage.getScene().getWindow();
        stage.close();
    }



}

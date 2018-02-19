package controllers;


import functionality.ClientServerConnection;
import functionality.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import models.User;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class RegisterController {

    private final String USER_TYPE = "STANDARD_USER";

    private Validator validator;
    private String hashedPassword;
    private User userRegistering;
    private ClientServerConnection clientServerConnection;

    @FXML
    private TextField firstNameText;
    @FXML
    private TextField secondNameText;
    @FXML
    private TextField emailText;
    @FXML
    private TextField mobileNumberText;
    @FXML
    private PasswordField passwordOne;
    @FXML
    private PasswordField passwordTwo;
    @FXML
    private Button registerButton;
    @FXML
    private Text whoopsMessage;
    @FXML
    private Text hintMessage;
    @FXML
    private Text existsText;


    @FXML
    private void sendRegisterRequest(){

        if(validateInputs()){
            hashPasswords();
            buildUserObject();

            clientServerConnection = new ClientServerConnection();
            String response = clientServerConnection.startRegisterRequest(userRegistering);

            if(response.equals("USER_EXISTS")){

                existsText.setVisible(true);
            }
            // if USER_REGISTERED
            // CLOSE THIS STAGE AND LOAD THE LOGIN STAGE.
        }
    }

    private void buildUserObject(){

        userRegistering = new User();
        userRegistering.setfName(firstNameText.getText());
        userRegistering.setsName(secondNameText.getText());
        userRegistering.setRole("unkwn");
        userRegistering.setMobileNo(mobileNumberText.getText());
        userRegistering.setEmail(emailText.getText());
        userRegistering.setUserType(USER_TYPE);
        userRegistering.setPassword(hashedPassword);
    }

    private void hashPasswords(){

        hashedPassword = BCrypt.hashpw(passwordOne.getText(), BCrypt.gensalt());
    }

    private boolean validateInputs(){

        boolean check;

        validator = new Validator();

        if(validator.validateString(firstNameText.getText())
                && validator.validateString(secondNameText.getText())
                && validator.validateEmail(emailText.getText())
                && validator.validatePasswordsMatch(passwordOne.getText(), passwordTwo.getText())){

            check = true;

        }else{
            check = false;
            whoopsMessage.setVisible(true);
            hintMessage.setVisible(true);
        }

        return check;
    }
}

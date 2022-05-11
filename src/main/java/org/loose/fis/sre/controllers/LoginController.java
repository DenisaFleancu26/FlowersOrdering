package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.InvalidValidationException;
import org.loose.fis.sre.services.UserService;

import java.io.File;

public class LoginController {

    @FXML
    private ImageView imageBackground;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox role;

    @FXML
    private TextField usernameField;

    @FXML
    private Text loginMessage;

    @FXML
    public void initialize() {
        role.getItems().addAll("Manager", "Customer");
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        imageBackground.setImage(fundalImage);
    }

    @FXML
    public void handleLoginAction() {
        try {
            int ok= UserService.checkInvalidLogin(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            if(ok==0) throw new InvalidValidationException();
        } catch (InvalidValidationException e) {
            loginMessage.setText(e.getMessage());
        }
    }
}

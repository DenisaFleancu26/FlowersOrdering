package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    public void initialize() {
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        imageBackground.setImage(fundalImage);
    }
}

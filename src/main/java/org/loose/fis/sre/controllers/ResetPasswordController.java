package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.exceptions.InvalidDataException;

import java.io.File;

public class ResetPasswordController {

    @FXML
    private Text resetMessage;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField confirmNewPasswordField;
    @FXML
    private ImageView imageBackground;

    @FXML
    public void initialize() {

        role.getItems().addAll("Manager", "Customer");
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        imageBackground.setImage(fundalImage);
    }

    @FXML
    public void ResetPassword(javafx.event.ActionEvent event) throws Exception {
        try {
            UserService.checkInvalidData(usernameField.getText(), (String) role.getValue(), newPasswordField.getText(), confirmNewPasswordField.getText());
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
            Pane root = fxmlLoader.load();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.setTitle("Login");
            stage.setScene(new Scene(root, 730, 468));
            stage.show();
        } catch (InvalidDataException e) {
            resetMessage.setText(e.getMessage());
        }
    }

}
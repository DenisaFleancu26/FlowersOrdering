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
import org.loose.fis.sre.exceptions.InvalidValidationException;
import org.loose.fis.sre.services.UserManagerService;
import org.loose.fis.sre.services.UserService;
import javafx.scene.control.Button;

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
    private Button SignUp;

    @FXML
    public void initialize() {
        role.getItems().addAll("Manager", "Customer");
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        imageBackground.setImage(fundalImage);
    }

    @FXML
    public void handleLoginAction(javafx.event.ActionEvent event) throws Exception {
        try {


            if (  ((String) role.getValue() )== "Customer") {

                int ok= UserService.checkInvalidLogin(usernameField.getText(), passwordField.getText(), (String) role.getValue());
                if(ok==0) throw new InvalidValidationException();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageCustomer.fxml"));
                Pane root = fxmlLoader.load();
                ((Node) (event.getSource())).getScene().getWindow().hide();
                stage.setTitle("Flowers Ordering (Customer)");
                stage.setScene(new Scene(root, 1200, 700));
                stage.show();
            }
            else {
                int ok = UserManagerService.checkInvalidLogin(usernameField.getText(), passwordField.getText(), (String) role.getValue());
                if (ok == 0) throw new InvalidValidationException();

                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageManager.fxml"));
                Pane root = fxmlLoader.load();
                ((Node) (event.getSource())).getScene().getWindow().hide();
                stage.setTitle("Flowers Ordering (Manager)");
                stage.setScene(new Scene(root, 1200, 700));
                stage.show();
            }

        } catch (InvalidValidationException e) {
            loginMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void handleResetPasswordAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("resetPassword.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Reset Password");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

    @FXML
    void handleSignUpAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Choose role type registration");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();

    }
}

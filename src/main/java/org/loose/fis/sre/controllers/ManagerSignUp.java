package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.EmailAlreadyExistsException;
import org.loose.fis.sre.exceptions.FlowerNameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserManagerService;

import java.io.File;

public class ManagerSignUp {

    @FXML
    private TextField AdressField;

    @FXML
    private Button Back;

    @FXML
    private TextField EmailField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private TextField PhoneNumberField;

    @FXML
    private Button SignUp;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField flowerShopNameField;

    @FXML
    private ImageView imageBackground;

    @FXML
    private Text registerMessage;

    @FXML
    public void initialize() {
        File fundalFile = new File("src/main/java/org/loose/fis/sre/images/fundal.jpg");
        Image fundalImage = new Image(fundalFile.toURI().toString());
        imageBackground.setImage(fundalImage);
    }

    @FXML
    void handleBackAction(javafx.event.ActionEvent event) throws Exception {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("register.fxml"));
        Pane root = fxmlLoader.load();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        stage.setTitle("Choose role type registration");
        stage.setScene(new Scene(root, 730, 468));
        stage.show();
    }

    @FXML
    void handleSignUpAction(javafx.event.ActionEvent event) throws Exception{
        try {
            UserManagerService.addUserManager(flowerShopNameField.getText(), UsernameField.getText(), PasswordField.getText(), AdressField.getText(), EmailField.getText(), PhoneNumberField.getText());
            registerMessage.setText("Account created successfully!");

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainPageManager.fxml"));
            Pane root = fxmlLoader.<Pane>load();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            stage.setTitle("Flowers Ordering (Manager)");
            stage.setScene(new Scene(root, 1200, 700));
            stage.show();

        } catch (UsernameAlreadyExistsException e) {
            registerMessage.setText(e.getMessage());
        } catch (EmailAlreadyExistsException e) {
            registerMessage.setText(e.getMessage());
        } catch (FlowerNameAlreadyExistsException e) {
            registerMessage.setText(e.getMessage());
        }

    }

}

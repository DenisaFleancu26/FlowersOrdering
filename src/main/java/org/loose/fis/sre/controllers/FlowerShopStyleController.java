package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.loose.fis.sre.model.UserManager;

import java.io.File;

public class FlowerShopStyleController {

    @FXML
    private ImageView ItemImage;

    @FXML
    private Label addressLabel;

    @FXML
    private Label addressLabel1;

    @FXML
    private Label emailLabel;

    @FXML
    private Label emailLabel1;

    @FXML
    private Label nameLabel;

    @FXML
    private Label nameLabel1;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label phoneLabel1;

    private UserManager flower;

    public void setData(UserManager flower){
        this.flower = flower;
        nameLabel1.setText(flower.getFlowerShopName());
        phoneLabel1.setText(flower.getPhoneNumber());
        emailLabel1.setText(flower.getEmail());
        addressLabel1.setText(flower.getEmail());
        File iconFile = new File("src/main/java/org/loose/fis/sre/Images/FloweShopItemStyleImg.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        ItemImage.setImage(iconImage);
    }

    public void setData() {
    }


}

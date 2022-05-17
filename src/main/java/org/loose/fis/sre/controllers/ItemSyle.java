package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.loose.fis.sre.model.Item;

public class ItemSyle {

    @FXML
    private ImageView ItemImage;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label sizeLabel;

    private Item item;

    public void setData(Item item){
        this.item = item;
        idLabel.setText(item.getId());
        nameLabel.setText(item.getName());
        priceLabel.setText(item.getPrice());
        sizeLabel.setText(item.getSize());
        var test = item.getImg().replace("\\\\","\\");
        try{
            ItemImage.setImage(new Image(item.getImg().replace("\\\\","\\")));
        }
        catch (Exception ex){
            System.out.println(item.getImg().replace("\\\\","\\"));
        }
    }

    public void setData() {
    }
}

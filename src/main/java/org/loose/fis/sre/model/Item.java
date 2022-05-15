package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.util.Objects;

public class Item {

    @Id
    private String id;
    private String name;
    private int price;
    private String size;

    public Item() {

    }

    public Item(String id, String name, int price, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }


}

package org.loose.fis.sre.exceptions;

public class FlowerNameAlreadyExistsException extends Exception {

    private String flowerName;

    public FlowerNameAlreadyExistsException(String flowerName) {
        super(String.format("An account with the flowersName %s already exists!", flowerName));
        this.flowerName = flowerName;
    }

    public String getFlowerName() {
        return flowerName;
    }
}

package org.loose.fis.sre.exceptions;

public class IdAlreadyExistsException extends Exception {

    private String id;

    public IdAlreadyExistsException(String id) {
        super(String.format("An item with the id %s already exists!", id));
        this.id = id;
    }

    public String getFlowerName() {
        return id;
    }
}

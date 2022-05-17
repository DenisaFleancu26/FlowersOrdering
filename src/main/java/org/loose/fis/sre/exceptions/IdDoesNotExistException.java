package org.loose.fis.sre.exceptions;

public class IdDoesNotExistException extends Exception {

    private String id;

    public IdDoesNotExistException(String id) {
        super(String.format("An item with the id %s not exists!", id));
        this.id = id;
    }

    public String getFlowerName() {
        return id;
    }
}
package org.loose.fis.sre.exceptions;

public class EmailAlreadyExistsException extends Exception {

    private String email;

    public EmailAlreadyExistsException(String email) {
        super(String.format("An account with the email %s already exists!", email));
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

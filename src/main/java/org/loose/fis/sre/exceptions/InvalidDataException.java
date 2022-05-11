package org.loose.fis.sre.exceptions;

public class InvalidDataException extends Exception{

    public InvalidDataException(){
        super(("Your data is invalid!"));
    }
}

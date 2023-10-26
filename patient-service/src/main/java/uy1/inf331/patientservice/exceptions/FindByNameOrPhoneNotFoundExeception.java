package uy1.inf331.patientservice.exceptions;

public class FindByNameOrPhoneNotFoundExeception extends Exception {
    public FindByNameOrPhoneNotFoundExeception(String message) {
        super(message);
    }

}
package com.satheesh.librarymanagement.database;

import java.util.regex.Pattern;

public class Validation {
    private static Validation validation;
    public static Validation getInstance(){
        if(validation==null){
            validation=new Validation();
        }
        return validation;
    }

    public boolean validateEmail(String emailId){
        return Pattern.matches(".*@gmail.com", emailId );
    }

    public boolean validateName(String name){
        return (name.length()>3 && name.length()<50);
    }

    public boolean validatePhoneNo(String phoneNo) {
        return Pattern.matches("\\d{10}+", phoneNo);
    }
}

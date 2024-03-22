package com.satheesh.interviewpanel.database;

import java.util.regex.Pattern;

public class ValidationCode {
    private static ValidationCode validationCode;
    public static ValidationCode getInstance(){
        if(validationCode==null){
            validationCode=new ValidationCode();
        }
        return validationCode;
    }
    public boolean validateEmail(String emailId){

        return Pattern.matches(".*@gmail.com", emailId );
    }

    public boolean validateName(String name){
        return (name.length()>3 && name.length()<50);
    }

    public boolean validateMobileNo(String phoneNo) {

        return Pattern.matches("\\d{10}+", phoneNo);
    }
}

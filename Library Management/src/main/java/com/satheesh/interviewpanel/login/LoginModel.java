package com.satheesh.interviewpanel.login;


import com.satheesh.interviewpanel.database.DbCode;
import com.satheesh.interviewpanel.manageinterview.InterviewPanelView;

import static com.satheesh.interviewpanel.database.DbCode.credentialsMap;

public class LoginModel {
    private  LoginView loginView;
    private InterviewPanelView interviewPanelView;

    public LoginModel(LoginView loginView){
        this.loginView=loginView;
    }
    public void validateUser(String userName, String password){
        if(isValidateUsername(userName)){
            if(isValidatePassword(password)){
                loginView.showAlert("Successfully login");
                loginView.success();
            }else{
                loginView.showAlert("Invalid password");
            }
        }else{
            loginView.showAlert("Invalid Username");
        }
    }

    private boolean isValidateUsername(String userName) {
        return DbCode.getInstance().credentialsMap.containsKey(userName);
    }
    private boolean isValidatePassword(String password) {

        return DbCode.getInstance().credentialsMap.containsValue(password);
    }


    public void passwordReset(String userName, String password) {
        DbCode.getInstance().credentialsMap.put(userName, password);
        loginView.proceedLogin();

    }
}

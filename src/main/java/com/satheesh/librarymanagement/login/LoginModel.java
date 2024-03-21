package com.satheesh.librarymanagement.login;

import com.satheesh.librarymanagement.LibraryManagement;
import com.satheesh.librarymanagement.managebook.ManageBookView;

class LoginModel {  //Remove the access specifier(public) because not access any where in this class.
    // It is also called security purpose.

    private LoginView loginView;
    private ManageBookView manageBookView=new ManageBookView();
    LoginModel(LoginView loginView){
        this.loginView = loginView;
    }

    /*validateUser is created to validate the username and password*/
    public void validateUser(String userName, String password) {
        if(isValidUserName(userName)){
            if(isValidPassword(password)){
                loginView.onSuccess();
            }else{
                loginView.showAlert("Invalid password");
            }
        }else{
            loginView.showAlert("Invalid username");
        }
    }

    private boolean isValidUserName(String userName){
        return userName.equals("zsgs");
    }

    private boolean isValidPassword(String password){
        return password.equals("Java@123");
    }


    public void librarySetup() {
        System.out.println("\n\nLogin successful...\n\n--- welcome to "+ LibraryManagement.getInstance().getAppName()+"- v"+LibraryManagement.getInstance().getAppVersion()+"----");
        manageBookView.init();
    }
}

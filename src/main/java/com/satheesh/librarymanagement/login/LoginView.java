package com.satheesh.librarymanagement.login;

import com.satheesh.librarymanagement.LibraryManagement;
import com.satheesh.librarymanagement.librarysetup.LibraryView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    public LoginView(){
        loginModel=new LoginModel(this);
    }
    public void logincode(){
        System.out.println("---"+ LibraryManagement.getInstance().getAppName()+"---\nversion"+LibraryManagement.getInstance().getAppVersion());
        Scanner scan=new Scanner(System.in);
        System.out.println("\n\nPlease login to proceed.");
        proceedLogin();
    }
    public void showAlert(String alertText){

        System.out.println(alertText);
    }
    private void checkForLogin() {
        System.out.println("Do you try again? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            proceedLogin();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n ---- Thanks You ----");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForLogin();
        }
    }


    public void onLoginFailed(String alertText) {
        System.out.println(alertText);
        checkForLogin();
    }
    public void onSuccess() {
        System.out.flush();
        System.out.println("\n\nLogin successful...\n\n--- welcome to "+LibraryManagement.getInstance().getAppName()+"- v"+LibraryManagement.getInstance().getAppVersion()+"----");
        LibraryView libraryView=new LibraryView();
        libraryView.init();
        //loginModel.librarySetup();
    }
    private void proceedLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the user name:");
        String userName = scanner.next();
        System.out.println("Enter the password:");
        String password = scanner.next();
        loginModel.validateUser(userName, password);
    }
}

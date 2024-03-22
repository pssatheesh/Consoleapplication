package com.satheesh.interviewpanel.login;

import com.satheesh.interviewpanel.InterviewPanel;
import com.satheesh.interviewpanel.manageinterview.InterviewPanelView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;
    private InterviewPanelView interviewPanelView;

    public LoginView(){
        loginModel =new LoginModel(this);
    }

    public void init(){
        System.out.println("--- " + InterviewPanel.getInstance().getAppName() + " --- \nversion "
                + InterviewPanel.getInstance().getAppVersion());
        System.out.println("\n\nPlease login to proceed.");
        proceedLogin();
    }

    public void proceedLogin() {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the username");
        String userName=scan.next();
        System.out.println("Enter the password");
        String password=scan.next();
        loginModel.validateUser(userName, password);
    }
    public void onLoginFailed(String alertText) {
        System.out.println(alertText);
        checkForLogin();
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
    public void showAlert(String alertText) {
        System.out.println(alertText);
    }

    public void success() {
        System.out.println("---Welcome to Satheesh Info---");
        System.out.println("To Reset your Username and password");
        InterviewPanelView interviewPanelView1=new InterviewPanelView();
        interviewPanelView1.init();
    }
    public void passwordReset(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter new username");
        String userName=scanner.next();
        System.out.println("Enter new password");
        String password=scanner.next();
        loginModel.passwordReset(userName,password);

    }

}

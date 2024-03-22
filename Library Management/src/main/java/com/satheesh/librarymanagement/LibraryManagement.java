package com.satheesh.librarymanagement;

import com.satheesh.librarymanagement.login.LoginView;

public class LibraryManagement {
    private static LibraryManagement libraryManagement;
    private String appName;
    private String appVersion="0.1.0";

    public static LibraryManagement getInstance(){
        if(libraryManagement==null){
            libraryManagement=new LibraryManagement();
        }
        return libraryManagement;
    }

    public void create(){
        LoginView loginView=new LoginView();
        loginView.logincode();
    }
    public String getAppName(){
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion(){
        return appVersion;
    }
    public static void main(String[] args) {
        libraryManagement.getInstance().create();
    }
}
/*Note:
* The static void main method only create this class only
* This class to access the LoginView(View Logic) class not access directly to the LoginModel class()
* */
package com.satheesh.interviewpanel;

import com.satheesh.interviewpanel.login.LoginView;

public class InterviewPanel {
    private static InterviewPanel interviewPanel;
    private String appName="InterviewPanel @ Satheesh Info";
    private String appVersion="0.1.0";
    private InterviewPanel(){

    }
    public static InterviewPanel getInstance(){
        if(interviewPanel==null){
            interviewPanel=new InterviewPanel();
        }
        return interviewPanel;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    private void create() {
        LoginView loginView=new LoginView();
        loginView.init();
    }
    public static void main(String[] args) {
        interviewPanel.getInstance().create();
    }


}

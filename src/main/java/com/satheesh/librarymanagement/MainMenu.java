package com.satheesh.librarymanagement;

import com.satheesh.librarymanagement.issuebook.IssueBookView;
import com.satheesh.librarymanagement.login.LoginView;
import com.satheesh.librarymanagement.manageUser.ManageUserView;
import com.satheesh.librarymanagement.managebook.ManageBookView;

import java.util.Scanner;

public class MainMenu {
    private static MainMenu mainMenu;
    private ManageBookView manageBookView=new ManageBookView();
    private ManageUserView manageUserView=new ManageUserView();
    public static MainMenu getInstance(){
        if(mainMenu==null){
            mainMenu=new MainMenu();
        }
        return mainMenu;
    }
    public void init(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Main Menu");
        while (true){
            System.out.println("1.Manage Book\n2.Manage User\n3.Book Issue Menu \n4.Logout \n5.Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    manageBookView.init();
                    break;
                case 2:
                    manageUserView.start();
                    break;
                case 3:
                    IssueBookView issueBookView=new IssueBookView();
                    issueBookView.init();
                    break;
                case 4:
                    System.out.println("Logout Successfully");
                    submenu();
                    break;
                case 5:
                    System.out.println("Exit the app");
                    System.exit(0);
                default:
                System.out.println("Invalid choice");
                init();
            }
        }
    }

    public void submenu(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Login\n2.Exit");
        System.out.println("Enter your choice");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                LoginView loginView=new LoginView();
                loginView.logincode();
                break;
            case 2:
                System.out.println("Exit the app");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                submenu();
        }
    }
}

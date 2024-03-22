package com.satheesh.librarymanagement.librarysetup;

import com.satheesh.interviewpanel.login.LoginView;
import com.satheesh.librarymanagement.LibraryManagement;
import com.satheesh.librarymanagement.manageUser.ManageUserView;
import com.satheesh.librarymanagement.managebook.ManageBookView;
import com.satheesh.librarymanagement.model.Library;

import java.util.Scanner;

public class LibraryView {
    private LibraryModel libraryModel;
    private ManageBookView manageBookView=new ManageBookView();
    private Library library=new Library();

    public LibraryView() {
        libraryModel = new LibraryModel(this);
    }
    public void init(){
        libraryModel.startSetup();
    }
    public void onSetupComplete(Library library){
        System.out.println("\nLibrary setup completed\n");
        System.out.println("\nCurrent Library Name - " + library.getLibraryName());
        manageBookView.init();

    }
    public void showAlert(String alert){

        System.out.println("\nPrint any errors here.");
    }
    public void intiateSetup(){
        System.out.println("\n\nEnter library details:");
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        System.out.println("\nEnter library name:");
        library.setLibraryName(scanner.nextLine());
        if(!libraryModel.validateName(library.getLibraryName())) {
            System.out.println("Invalid name");
            System.out.println("Please Reenter the details");
            intiateSetup();
        }
        System.out.println("\nEnter library email:");
        library.setEmailId(scanner.nextLine());
        if(!libraryModel.validateEmailId(library.getEmailId())) {
            System.out.println("Invalid email");
            System.out.println("Please Reenter the details");
            intiateSetup();
        }
        libraryModel.createLibrary(library);
    }
}
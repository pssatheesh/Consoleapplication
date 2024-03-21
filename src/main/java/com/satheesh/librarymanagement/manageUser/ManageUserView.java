package com.satheesh.librarymanagement.manageUser;

import com.satheesh.librarymanagement.model.User;

import java.util.Scanner;

public class ManageUserView {
    private ManageUserModel manageUserModel;
    public ManageUserView(){
        manageUserModel=new ManageUserModel(this);
    }
    public void initAdd() {
        System.out.println("Enter the following user Details: ");
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("\nEnter user name:");
        user.setName(scanner.nextLine());
        System.out.println("\nEnter user emailId:");
        user.setEmailId(scanner.next());
        if(!manageUserModel.validateEmailId(user.getEmailId())) {
            System.out.println("Invalid email");
            initAdd();
        }
        System.out.println("\nEnter user Phone number");
        user.setPhoneNo(scanner.next());
        System.out.println("\nEnter the Government Id Proof type");
        user.setGovtIdType(scanner.next());
        System.out.println("\nEnter the Government Id Number");
        user.setGovtIdNumber(scanner.next());
        manageUserModel.addNewUser(user);
    }


    public void showLibraryName(String libraryName) {
        System.out.println("Current Library Name - " + libraryName);
    }

    public void onUserAdded(User user) {
        System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
        checkForAddNewUser();
    }

    public void onUserExist(User user) {
        System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
        checkForAddNewUser();
    }

    private void checkForAddNewUser() {
        System.out.println("Do you want to add more users? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            initAdd();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewUser();
        }
    }

    public void viewUser() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the EmailId:");
        String emailId=scanner.next();
        manageUserModel.viewUserDetails(emailId);
    }
}

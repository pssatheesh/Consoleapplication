package com.satheesh.librarymanagement.manageUser;

import com.satheesh.librarymanagement.MainMenu;
import com.satheesh.librarymanagement.managebook.ManageBookView;
import com.satheesh.librarymanagement.model.Book;
import com.satheesh.librarymanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class ManageUserView {
    private ManageUserModel manageUserModel;

    public ManageUserView() {
        manageUserModel = new ManageUserModel(this);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu");
            System.out.println("1.Add customers\n2.View Customers Details\n3.Delete the User \n4.Back to MainMenu");
            System.out.println("Enter your choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    initAdd();
                    break;
                case 2:
                    viewUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    MainMenu.getInstance().init();
                    break;
                default:
                    System.out.println("Invalid choice");
                    start();
            }
        }
    }

    private void deleteUser() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the User Id: ");
        int userId = scanner.nextInt();
        manageUserModel.userDelete(userId);
    }

    public void initAdd() {
        System.out.println("Enter the following user Details: ");
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("\nEnter user name:");
        user.setName(scanner.nextLine());
        if (!manageUserModel.validateName(user.getName())) {
            System.out.println("Invalid name");
            System.out.println("Please Reenter the details");
            initAdd();
            return;
        }
        System.out.println("Enter the UserId");
        user.setId(scanner.nextInt());
        System.out.println("\nEnter user emailId:");
        user.setEmailId(scanner.next());
        if (!manageUserModel.validateEmailId(user.getEmailId())) {
            System.out.println("Invalid email");
            System.out.println("Please Reenter the details");
            initAdd();
            return;
        }
        System.out.println("\nEnter user Phone number");
        user.setPhoneNo(scanner.next());
        if (!manageUserModel.validatePhoneNo(user.getPhoneNo())) {
            System.out.println("Invalid Mobile No");
            System.out.println("Please Reenter the details");
            initAdd();
            return;
        }
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
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            initAdd();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding users");
            // manageBookView.init();
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewUser();
        }
    }

    public void viewUser() {
        List<User> user = manageUserModel.getAllUsers();
        System.out.println("UserName\tUserId\tPhoneNo\tGmailId\tGovt Id Type\tGovt Id Number");
        for (User users : user) {
            System.out.println(users);
        }
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}

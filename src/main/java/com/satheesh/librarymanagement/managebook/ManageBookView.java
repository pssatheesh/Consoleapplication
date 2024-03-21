package com.satheesh.librarymanagement.managebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.satheesh.librarymanagement.login.LoginView;
import com.satheesh.librarymanagement.manageUser.ManageUserView;
import com.satheesh.librarymanagement.model.Book;

public class ManageBookView {
    private ManageBookModel manageBookModel;
    private  ManageUserView  manageUserView=new ManageUserView();

    public ManageBookView(){
        manageBookModel=new ManageBookModel(this);
    }

    public void init() {
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("1.Add Book\n2.View Book\n3.Delete Book \n4.Update the Books count \n5.Add customers \n6.View User Details \n7.Logout\n8.Exit");
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the Book Name:");
                    String bookName = scanner.next();
                    System.out.println("Enter the Book id:");
                    int bookId = scanner.nextInt();
                    System.out.println("Enter the Book Author:");
                    String author = scanner.next();
                    System.out.println("Enter the Book Publication:");
                    String publication = scanner.next();
                    System.out.println("Enter the Book Edition:");
                    String edition = scanner.next();
                    System.out.println("Enter the Book genre:");
                    String genre = scanner.next();
                    System.out.println("Enter the Book Avaliability count:");
                    int availableCount = scanner.nextInt();
                    System.out.println("Enter the Book Volume:");
                    int volume = scanner.nextInt();
                    boolean res = manageBookModel.bookAdd(bookName, bookId, author, publication, edition, genre, availableCount, volume);
                    if (res) {
                        System.out.println("Book details added successfully");
                    } else {
                        System.out.println("Connection error");
                    }
                    break;
                } case 2: {
                    //print the book details
                    List<Book> books = manageBookModel.getAllBooks();
                    System.out.println("BookName\tBookId\tAuthor\tPublication\tedition\tgenre\tAvailableCount\tVolume");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                } case 3: {
                    //delete the given book
                    System.out.println("Enter the Book Id: ");
                    int bookId = scanner.nextInt();
                    manageBookModel.bookDelete(bookId);
                    break;
                } case 4: {
                    //update the given book
                    System.out.println("Enter the Book Id: ");
                    int bookId = scanner.nextInt();
                    System.out.println("Enter Available count:");
                    int avaliableCount = scanner.nextInt();
                    manageBookModel.bookUpdate(bookId, avaliableCount);
                    break;
                } case 5: {
                    // Customer Creation
                    manageUserView.initAdd();
                    break;
                } case 6: {
                    // View Customer details
                    manageUserView.viewUser();
                    break;
                } case 7:{
                    System.out.println("Logout Successfully");
                    LoginView loginView=new LoginView();
                    loginView.logincode();
                    break;
                }
                case 8: {
                    System.out.println("Exit the app");
                    break;
                } default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

    }
    public void showAlert(String alertText){
        System.out.println(alertText);
    }



}

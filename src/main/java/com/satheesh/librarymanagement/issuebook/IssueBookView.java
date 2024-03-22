package com.satheesh.librarymanagement.issuebook;

import com.satheesh.librarymanagement.MainMenu;
import com.satheesh.librarymanagement.managebook.ManageBookView;
import com.satheesh.librarymanagement.model.IssueBook;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IssueBookView {
    private IssueBookModel issueBookModel;

    public IssueBookView(){
        issueBookModel=new IssueBookModel(this);
    }
    public void init(){
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("1.Add\n2.Issue history\n3.Update return date\n4.Back to Mainmenu");
            System.out.println("Enter your choice:");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:{
                    System.out.println("Enter the UserId");
                    int userId=scanner.nextInt();
                    System.out.println("Enter the BookId");
                    int bookId=scanner.nextInt();
                    System.out.println("Enter the count of Book");
                    int bookCount=scanner.nextInt();
                    LocalDate issueDate= LocalDate.now();
                    LocalDate returnDate=issueDate.plusDays(15);
                    boolean res=issueBookModel.addBookDetails(userId, bookId,bookCount, issueDate, returnDate);
                    if(res){
                        System.out.println("Added sucessfully");
                    }
                    System.out.println("You return the book on or before 15 days");
                    break;
                }
                case 2:{
                    //view all issued details;
                    List<IssueBook> issueDetails=issueBookModel.getAllDetails();
                    for(IssueBook issueBook:issueDetails){
                        System.out.println(issueBook);
                    }
                    break;
                }
                case 3:{
                    //update return book date
                    System.out.println("Enter the userId");
                    int userId=scanner.nextInt();
                    System.out.println("Enter the BookId");
                    int bookId=scanner.nextInt();
                    LocalDate returnDate=LocalDate.now();
                    issueBookModel.returnBookUpdate(userId, bookId, returnDate);
                    break;
                }
                case 4:{
                    MainMenu.getInstance().init();
                    break;
                }
                default:
                    System.out.println("Bad Choice");
                    init();
            }
        }
    }
}

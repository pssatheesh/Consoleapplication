package com.satheesh.librarymanagement.issuebook;

import com.satheesh.librarymanagement.database.DbCode;
import com.satheesh.librarymanagement.model.IssueBook;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class IssueBookModel {
    private IssueBookView issueBookView;
    public IssueBookModel(IssueBookView issueBookView){
        this.issueBookView=issueBookView;
    }

    public boolean addBookDetails(int userId, int bookId, int bookCount, LocalDate issueDate, LocalDate returnDate) {
        DbCode.getInstance().addUserBookDetails(new IssueBook(userId, bookId, bookCount, issueDate.toString(), returnDate.toString()));
        DbCode.getInstance().pushIssueBookDataToJson();
        return true;
    }

    public void returnBookUpdate(int userId, int bookId, LocalDate returnDate) {
        DbCode.getInstance().returnBookUpdate(userId, bookId, returnDate);
        DbCode.getInstance().pushIssueBookDataToJson();
    }

    public List<IssueBook> getAllDetails() {
        DbCode.getInstance().pullIssueBookDataToJson();
        return DbCode.getInstance().getAllIssuedDetails();
    }
}

package com.satheesh.librarymanagement.model;

import java.time.LocalDate;

public class IssueBook {
    private int userId;
    private int bookId;
    private int countOfBook;
    private String issueDate;
    private String returnDate;
    public IssueBook(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCountOfBook() {
        return countOfBook;
    }

    public void setCountOfBook(int countOfBook) {
        this.countOfBook = countOfBook;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public IssueBook(int userId, int bookId, int countOfBook, String issueDate, String returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.countOfBook = countOfBook;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "IssueBook{" +
                "userId=" + userId +
                ", bookId=" + bookId +
                ", countOfBook=" + countOfBook +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}

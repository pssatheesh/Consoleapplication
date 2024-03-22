package com.satheesh.librarymanagement.model;

public class Book {
    private String bookName;
    private int bookId;
    private String author;

    private String publication;
    private String edition;
    private String journer;
    private int availableCount;
    private int volume;
    public Book(){}

    public Book(String bookName, int bookId, String author, String publication, String edition, String journer, int availableCount, int volume) {
        this.bookName = bookName;
        this.bookId = bookId;
        this.author = author;
        this.publication = publication;
        this.edition = edition;
        this.journer = journer;
        this.availableCount = availableCount;
        this.volume = volume;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getJourner() {
        return journer;
    }

    public void setJourner(String journer) {
        this.journer = journer;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return  bookName  +
                "\t" + bookId +
                "\t" + author +
                "\t" + publication +
                "\t" + edition +
                "\t" + journer +
                "\t" + availableCount +
                "\t" + volume ;
    }
}

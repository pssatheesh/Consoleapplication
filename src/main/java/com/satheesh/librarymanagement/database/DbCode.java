package com.satheesh.librarymanagement.database;

import com.satheesh.librarymanagement.model.Book;
import com.satheesh.librarymanagement.model.Library;
import com.satheesh.librarymanagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class DbCode {

    private static DbCode dbCode;
    private static Book book;
    private Library library;
    private static List<Book> bookStorage =new ArrayList<Book>();
    private List<User> userList = new ArrayList();
    public static DbCode getInstance(){
        if(dbCode==null){
            dbCode =new DbCode();
        }
        return dbCode;
    }
    public Library getLibrary() {
        return library;// SQL query and it's result here.
    }

    public Library insertLibrary(Library library2) {
        this.library = library2;
        this.library.setLibraryId(1);
        return library;
    }
    public List<Book> searchBooks(String bookName) {
        List<Book> searchResult = new ArrayList();
        for (Book book : bookStorage) {
            if (book.getBookName().contains(bookName)) {
                searchResult.add(book);
            }
        }
        // select query with where condition.
        return searchResult;
    }



    public void setBookStorage(Book book){
        bookStorage.add(book);
    }

    public List<Book> getAllBooks()
    {
        return bookStorage;
    }

    public boolean deleteBook(int bookId){
        for(Book books:bookStorage){
            if(books.getBookId()==bookId){
                bookStorage.remove(books);
                break;
            }
        }
        return true;
    }

    public boolean updateBook(int bookId, int avaliableCount) {
        for(Book books:bookStorage){
            if(books.getBookId()==bookId){
                books.setAvailableCount(avaliableCount);
                break;
            }
        }
        return true;
    }

    public boolean insertUser(User user) {
        boolean hasUser = false;
        for (User addedUser : userList) {
            if (addedUser.getEmailId().equals(user.getEmailId())) {
                hasUser = true;
                break;
            }
        }
        if (hasUser) {
            return false;
        } else {
            userList.add(user);
            return true;
        }
    }

    public User getUserDetails(String emailId){
        for(User user:userList){
            if(user.getEmailId().equals(emailId)){
                return user;
            }
        }
        return null;
    }
}


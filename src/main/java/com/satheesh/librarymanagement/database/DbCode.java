package com.satheesh.librarymanagement.database;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satheesh.librarymanagement.model.Book;
import com.satheesh.librarymanagement.model.IssueBook;
import com.satheesh.librarymanagement.model.Library;
import com.satheesh.librarymanagement.model.User;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbCode {

    private static DbCode dbCode;
    private static Book book;
    private Library library;
    private static List<Book> bookStorage =new ArrayList<Book>();
    private List<User> userList = new ArrayList();
    private List<IssueBook> userBookDetails=new ArrayList<>();
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
    //Book database code
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

    //User Database Code

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

    public List<User> getAllUsers() {
        return userList;
    }

    public boolean deleteUser(int userId) {
        for(User users:userList){
            if(users.getId()==userId){
                userList.remove(users);
                break;
            }
        }
        return true;
    }

    //issue Book database
    public boolean addUserBookDetails(IssueBook issueBook) {
        return userBookDetails.add(issueBook);
    }


    public void returnBookUpdate(int userId, int bookId, LocalDate returnDate) {
        for(IssueBook issue:userBookDetails){
            if(issue.getUserId()==userId && issue.getBookId()==bookId){
                issue.setReturnDate(returnDate.toString());
            }
        }
    }

    public List<IssueBook> getAllIssuedDetails() {
        return userBookDetails;
    }
    // json Book pull and push datas
    public void pushBookDataToJson(){
        //code push to Json
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("target/Bookdetails.json");
        try{
            objectMapper.writeValue(file, bookStorage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pullBookDataToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/Bookdetails.json");
        try {
           bookStorage.clear();
            List<Book> deserializedUsers = objectMapper.readValue(file, new TypeReference<List<Book>>(){});
            bookStorage.addAll(deserializedUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Json User pull and push datas
    public void pushUserDataToJson(){
        //code push to Json
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("target/User.json");
        try{
            objectMapper.writeValue(file, userList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pullUserDataToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/User.json");
        try {
            userList.clear();
            List<User> deserializedUsers = objectMapper.readValue(file, new TypeReference<List<User>>(){});
            userList.addAll(deserializedUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // json Issue Book pull and push datas
    public void pushIssueBookDataToJson(){
        //code push to Json
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("target/IssueBookdetails.json");
        try{
            objectMapper.writeValue(file, userBookDetails);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pullIssueBookDataToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/IssueBookdetails.json");
        try {
            userBookDetails.clear();
            List<IssueBook> deserializedUsers = objectMapper.readValue(file, new TypeReference<List<IssueBook>>(){});
            userBookDetails.addAll(deserializedUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


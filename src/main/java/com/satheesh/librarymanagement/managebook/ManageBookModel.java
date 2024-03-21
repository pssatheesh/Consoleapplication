package com.satheesh.librarymanagement.managebook;

import com.satheesh.librarymanagement.database.DbCode;
import com.satheesh.librarymanagement.model.Book;
import com.satheesh.librarymanagement.model.User;

import java.util.List;

public class ManageBookModel {
    private ManageBookView manageBookView;
    ManageBookModel(ManageBookView manageBookView){
        this.manageBookView=manageBookView;
    }

    public boolean bookAdd(String bookName,int bookId, String author, String publication, String edition,String journer,int availableCount,int volume) {
        DbCode.getInstance().setBookStorage(new Book(bookName, bookId,author,publication,edition,journer,availableCount,volume));
        return true;
    }

    public List<Book> getAllBooks() {
            return DbCode.getInstance().getAllBooks();
    }

    public void bookDelete(int bookId) {
        boolean res= DbCode.getInstance().deleteBook(bookId);
        if(res){
            manageBookView.showAlert("Updated Successfully");
        }else{
            manageBookView.showAlert("Book Id is not found");
        }
    }

    public void bookUpdate(int bookId, int avaliableCount) {
        boolean res=DbCode.getInstance().updateBook(bookId, avaliableCount);
        if(res){
            manageBookView.showAlert("Updated Successfully");
        }else{
            manageBookView.showAlert("Book is not found");
        }
    }
}

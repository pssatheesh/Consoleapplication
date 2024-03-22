package com.satheesh.librarymanagement.librarysetup;

import com.satheesh.librarymanagement.database.DbCode;
import com.satheesh.librarymanagement.database.Validation;
import com.satheesh.librarymanagement.model.Library;

public class LibraryModel {
    private LibraryView libraryView;
    private Library library=new Library();
    LibraryModel(LibraryView libraryView){
        this.libraryView = libraryView;
    }
    
    public void startSetup(){
        if(library ==null || library.getLibraryId()==0){
            libraryView.intiateSetup();
        }else{
            libraryView.onSetupComplete(library);
        }
    }


    public void createLibrary(Library library) {
        this.library=DbCode.getInstance().insertLibrary(library);
        libraryView.onSetupComplete(library);
    }

    public boolean validateEmailId(String emailId) {
        return Validation.getInstance().validateEmail(emailId);
    }

    public boolean validateName(String libraryName) {
        return Validation.getInstance().validateName(libraryName);
    }
}

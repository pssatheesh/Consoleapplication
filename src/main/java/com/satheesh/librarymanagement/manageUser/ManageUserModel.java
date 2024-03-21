package com.satheesh.librarymanagement.manageUser;

import com.satheesh.librarymanagement.database.DbCode;
import com.satheesh.librarymanagement.database.Validation;
import com.satheesh.librarymanagement.model.User;

class ManageUserModel {
    private ManageUserView manageUserView;

    ManageUserModel(ManageUserView manageUserView){
        this.manageUserView=manageUserView;
    }
    public void addNewUser(User user) {
        if (DbCode.getInstance().insertUser(user)) {
            manageUserView.onUserAdded(user);
        } else {
            manageUserView.onUserExist(user);
        }
    }



    public void viewUserDetails(String emailId) {
        DbCode.getInstance().getUserDetails(emailId);
    }

    public boolean validateEmailId(String emailId) {
        return Validation.getInstance().validateEmail(emailId);
    }
}

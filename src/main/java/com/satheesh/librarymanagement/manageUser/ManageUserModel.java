package com.satheesh.librarymanagement.manageUser;

import com.satheesh.librarymanagement.database.DbCode;
import com.satheesh.librarymanagement.database.Validation;
import com.satheesh.librarymanagement.model.User;

import java.util.List;

class ManageUserModel {
    private ManageUserView manageUserView;

    ManageUserModel(ManageUserView manageUserView){
        this.manageUserView=manageUserView;
    }
    public void addNewUser(User user) {
        if (DbCode.getInstance().insertUser(user)) {
            manageUserView.onUserAdded(user);
            DbCode.getInstance().pushUserDataToJson();
        } else {
            manageUserView.onUserExist(user);
        }
    }





    public boolean validateEmailId(String emailId) {
        return Validation.getInstance().validateEmail(emailId);
    }

    public boolean validateName(String name) {
        return Validation.getInstance().validateName(name);
    }

    public boolean validatePhoneNo(String phoneNo) {
        return Validation.getInstance().validatePhoneNo(phoneNo);
    }

    public void userDelete(int userId) {
        boolean res= DbCode.getInstance().deleteUser(userId);
        if(res){
            manageUserView.showAlert("Updated Successfully");
            DbCode.getInstance().pushUserDataToJson();
        }else{
            manageUserView.showAlert("Book Id is not found");
        }
    }


    public List<User> getAllUsers() {
        DbCode.getInstance().pullUserDataToJson();
        return DbCode.getInstance().getAllUsers();
    }
}

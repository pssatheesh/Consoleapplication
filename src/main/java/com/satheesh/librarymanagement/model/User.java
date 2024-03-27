package com.satheesh.librarymanagement.model;

public class User {
    private String name;
    private int id;
    private String phoneNo;
    private String emailId;
    private String govtIdType;
    private String govtIdNumber;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getGovtIdType() {
        return govtIdType;
    }

    public void setGovtIdType(String govtIdType) {
        this.govtIdType = govtIdType;
    }

    public String getGovtIdNumber() {
        return govtIdNumber;
    }

    public void setGovtIdNumber(String govtIdNumber) {
        this.govtIdNumber = govtIdNumber;
    }

    @Override
    public String toString() {
        return  name + '\t' +
                "\t" + id +
                "\t" + phoneNo +
                "\t" + emailId +
                "\t" + govtIdType +
                "\t" + govtIdNumber ;
    }
}

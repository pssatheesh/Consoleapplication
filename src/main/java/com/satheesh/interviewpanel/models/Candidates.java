package com.satheesh.interviewpanel.models;

public class Candidates {
    private int candidateId;
    private String candidateName;
    private String mobileNo;
    private String location;
    private String inDate;
    private String inTime;
    private String candidateStatus;
    private String outDate;
    private String outTime;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getCandidateStatus() {
        return candidateStatus;
    }

    public void setCandidateStatus(String candidateStatus) {
        this.candidateStatus = candidateStatus;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public Candidates(int candidateId, String candidateName, String mobileNo, String location, String inDate, String inTime, String candidateStatus) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.mobileNo = mobileNo;
        this.location = location;
        this.inDate = inDate;
        this.inTime = inTime;
        this.candidateStatus = candidateStatus;
        this.outDate = null;
        this.outTime = null;
    }

    @Override
    public String toString() {
        return  candidateId +
                "\t" + candidateName +
                "\t" + mobileNo +
                "\t" + location +
                "\t" + inDate +
                "\t" + inTime +
                "\t" + candidateStatus +
                "\t" + outDate +
                "\t" + outTime  ;
    }
}

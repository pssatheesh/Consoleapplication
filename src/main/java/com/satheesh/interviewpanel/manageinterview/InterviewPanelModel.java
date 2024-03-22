package com.satheesh.interviewpanel.manageinterview;

import com.satheesh.interviewpanel.database.DbCode;
import com.satheesh.interviewpanel.database.ValidationCode;
import com.satheesh.interviewpanel.models.Candidates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Queue;

public class InterviewPanelModel {
    private InterviewPanelView interviewPanelView;

    InterviewPanelModel(InterviewPanelView interviewPanelView){
        this.interviewPanelView=interviewPanelView;
    }

    public void candidateAdd(int candidateId, String candidateName, String mobileNo, String location, String candidateStatus, LocalDate inDate, LocalTime inTime) {
        DbCode.getInstance().setCandidates(new Candidates(candidateId, candidateName, mobileNo, location, candidateStatus, inDate.toString(), inTime.toString()));
        DbCode.getInstance().pushInterviewCandidateDataToJson();
        DbCode.getInstance().pushTodayInterviewCandidateDataToJson();
    }

    public Queue<Candidates> candidateView() {
        DbCode.getInstance().pullInterviewCandidateDataToJson();
        return DbCode.getInstance().getCandidatesList();
    }

    public void candidateStatusUpdate(int candidateId, String candidateStatus) {
        DbCode.getInstance().statusUpdate(candidateId, candidateStatus);
        DbCode.getInstance().pushInterviewCandidateDataToJson();
        DbCode.getInstance().pushTodayInterviewCandidateDataToJson();
    }

    public void candidateOutUpdate(int candidateId, LocalDate outDate, LocalTime outTime) {
        DbCode.getInstance().outUpdate(candidateId, outDate, outTime);
        DbCode.getInstance().pushInterviewCandidateDataToJson();
        DbCode.getInstance().pushTodayInterviewCandidateDataToJson();
    }

    public List<Candidates> todayCandidateView() {
        DbCode.getInstance().pullTodayInterviewCandidateDataToJson();
        return DbCode.getInstance().getTodayCandidatesList();
    }

    public boolean validateName(String candidateName) {
        return ValidationCode.getInstance().validateName(candidateName);
    }

    public boolean validateMobileNo(String mobileNo) {
        return ValidationCode.getInstance().validateMobileNo(mobileNo);
    }
}

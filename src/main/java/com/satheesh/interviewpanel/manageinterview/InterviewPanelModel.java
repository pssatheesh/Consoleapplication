package com.satheesh.interviewpanel.manageinterview;

import com.satheesh.interviewpanel.database.DbCode;
import com.satheesh.interviewpanel.models.Candidates;

import java.util.List;
import java.util.Queue;

public class InterviewPanelModel {
    private InterviewPanelView interviewPanelView;

    InterviewPanelModel(InterviewPanelView interviewPanelView){
        this.interviewPanelView=interviewPanelView;
    }

    public void candidateAdd(int candidateId, String candidateName, String mobileNo, String location, String inDate, String inTime, String candidateStatus) {
        DbCode.getInstance().setCandidates(new Candidates(candidateId, candidateName, mobileNo, location, inDate, inTime, candidateStatus));
    }

    public Queue<Candidates> candidateView() {
        return DbCode.getInstance().getCandidatesList();
    }

    public void candidateStatusUpdate(int candidateId, String candidateStatus) {
        DbCode.getInstance().statusUpdate(candidateId, candidateStatus);
    }

    public void candidateOutUpdate(int candidateId, String outDate, String outTime) {
        DbCode.getInstance().outUpdate(candidateId, outDate, outTime);
    }

    public List<Candidates> todayCandidateView() {
        return DbCode.getInstance().getTodayCandidatesList();
    }
}

package com.satheesh.interviewpanel.database;

import com.satheesh.interviewpanel.login.LoginView;
import com.satheesh.interviewpanel.models.Candidates;

import java.util.*;

public class DbCode {
    private static DbCode dbCode;
    private static Candidates candidates;

    private static Queue<Candidates> candidatesList=new LinkedList<>();
    private static List<Candidates> todayCandidatesList=new ArrayList<>();
    public static Map<String, String> credentialsMap=new HashMap<>();

    private DbCode(){
        credentialsMap.put("Admin","admin");
    }
    public static DbCode getInstance(){
        if(dbCode==null){
            dbCode=new DbCode();
        }
        return dbCode;
    }

    public void setCandidates(Candidates candidates) {
        candidatesList.add(candidates);
        todayCandidatesList.add(candidates);
    }


    public static Queue<Candidates> getCandidatesList() {
        return candidatesList;
    }

    public void statusUpdate(int candidateId, String candidateStatus) {
        for(Candidates candidates:candidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setCandidateStatus(candidateStatus);
                break;
            }
        }
        for(Candidates candidates:todayCandidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setCandidateStatus(candidateStatus);
                break;
            }
        }

    }

    public void outUpdate(int candidateId, String outDate, String outTime) {
        for(Candidates candidates:candidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setOutDate(outDate);
                candidates.setOutTime(outTime);
                candidatesList.remove();
            }
        }
        for(Candidates candidates:todayCandidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setOutDate(outDate);
                candidates.setOutTime(outTime);
            }
        }
    }

    public List<Candidates> getTodayCandidatesList() {
        return todayCandidatesList;
    }
}

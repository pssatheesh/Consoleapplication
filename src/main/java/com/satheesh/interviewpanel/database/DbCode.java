package com.satheesh.interviewpanel.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.satheesh.interviewpanel.login.LoginView;
import com.satheesh.interviewpanel.models.Candidates;
import com.satheesh.librarymanagement.model.IssueBook;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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

    public void outUpdate(int candidateId, LocalDate outDate, LocalTime outTime) {
        for(Candidates candidates:candidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setOutDate(outDate.toString());
                candidates.setOutTime(outTime.toString());
                candidatesList.remove();
            }
        }
        for(Candidates candidates:todayCandidatesList){
            if(candidates.getCandidateId()==candidateId){
                candidates.setOutDate(outDate.toString());
                candidates.setOutTime(outTime.toString());
            }
        }
    }
    //Add today interview candidates details in json file
    public List<Candidates> getTodayCandidatesList() {
        return todayCandidatesList;
    }
    public void pushInterviewCandidateDataToJson(){
        //code push to Json
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("target/InterviewCandidatedetails.json");
        try{
            objectMapper.writeValue(file, candidatesList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pullInterviewCandidateDataToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/InterviewCandidateDetails.json");
        try {
            candidatesList.clear();
            List<Candidates> deserializedUsers = objectMapper.readValue(file, new TypeReference<List<Candidates>>(){});
            candidatesList.addAll(deserializedUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Add the total day interview candidates details in json file
    public void pushTodayInterviewCandidateDataToJson(){
        //code push to Json
        ObjectMapper objectMapper=new ObjectMapper();
        File file=new File("target/TodayInterviewCandidatedetails.json");
        try{
            objectMapper.writeValue(file, todayCandidatesList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pullTodayInterviewCandidateDataToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("target/TodayInterviewCandidateDetails.json");
        try {
            todayCandidatesList.clear();
            List<Candidates> deserializedUsers = objectMapper.readValue(file, new TypeReference<List<Candidates>>(){});
            todayCandidatesList.addAll(deserializedUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

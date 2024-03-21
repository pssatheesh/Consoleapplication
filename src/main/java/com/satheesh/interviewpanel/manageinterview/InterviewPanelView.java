package com.satheesh.interviewpanel.manageinterview;

import com.satheesh.interviewpanel.models.Candidates;
import com.satheesh.librarymanagement.managebook.ManageBookModel;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InterviewPanelView {
    private InterviewPanelModel interviewPanelModel;
    public InterviewPanelView(){
        interviewPanelModel=new InterviewPanelModel(this);
    }

    public void init() {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Interview panel \n1.Add Candidate\n2.View List of Candidates\n3.Update status\n4.Update Outtime\n5.View Today Full candidates details \n6.Exit");
            System.out.println("Enter your choice");
            int choice=scanner.nextInt();
            if(choice==1){//Add the interviewer details
                System.out.println("Enter the Id Number");
                int candidateId=scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                System.out.println("Enter the Candidate Name");
                String candidateName=scanner.nextLine();
                System.out.println("Enter the Candidate Mobile No");
                String mobileNo=scanner.next();
                System.out.println("Enter the Current Location");
                String location=scanner.next();
                System.out.println("Enter the In Date(DD/MM/YYYY)");
                String inDate=scanner.next();
                System.out.println("Enter the In Time");
                String inTime=scanner.next();
                System.out.println("Enter the Status of Interviwer");
                String candidateStatus=scanner.next();
                interviewPanelModel.candidateAdd(candidateId, candidateName, mobileNo, location, inDate, inTime, candidateStatus);

            }else if(choice==2){
                //view
                Queue<Candidates> candidates= interviewPanelModel.candidateView();
                System.out.println("Candidate Id\tCandidate Name\tMobileNo\tLocation\tIn Date\tIn Time\tOut Date\tOut Time");
                for(Candidates c:candidates){
                    System.out.println(c);
                }
            }else if(choice==3){
                System.out.println("Enter the Candidate Id");
                int candidateId= scanner.nextInt();
                System.out.println("Enter the Candidate Status");
                String candidateStatus=scanner.next();
                interviewPanelModel.candidateStatusUpdate(candidateId, candidateStatus);
            }else if(choice==4){
                System.out.println("Enter the Candidate Id");
                int candidateId= scanner.nextInt();
                System.out.println("Enter the Out Date(DD/MM/YYYY)");
                String outDate=scanner.next();
                System.out.println("Enter the Out Time(HH:MM)");
                String outTime=scanner.next();
                interviewPanelModel.candidateOutUpdate(candidateId, outDate, outTime);

            }else if(choice==5){
                List<Candidates> candidates= interviewPanelModel.todayCandidateView();
                for(Candidates c:candidates){
                    System.out.println(c);
                }
            }
            else if(choice==6){
                System.out.println("Logout Successfully");
                break;
            }else{
                System.out.println("Bad choice");
            }
        }


    }
}

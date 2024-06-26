package com.satheesh.interviewpanel.manageinterview;

import com.satheesh.interviewpanel.login.LoginView;
import com.satheesh.interviewpanel.models.Candidates;
import com.satheesh.librarymanagement.managebook.ManageBookModel;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InterviewPanelView {
    private InterviewPanelModel interviewPanelModel;
    private LoginView loginView=new LoginView();
    public InterviewPanelView(){
        interviewPanelModel=new InterviewPanelModel(this);
    }

    public void init() {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("Interview panel \n1.Add Candidate\n2.View List of Candidates\n3.Update status\n4.Update Outtime\n5.View Today Full candidates details \n6.Reset password \n7.Exit");
            System.out.println("Enter your choice");
            int choice=scanner.nextInt();
            if(choice==1){//Add the interviewer details
                System.out.println("Enter the Id Number");
                int candidateId=scanner.nextInt();
                System.out.println();
                scanner.nextLine();
                System.out.println("Enter the Candidate Name");
                String candidateName=scanner.nextLine();
                if(!interviewPanelModel.validateName(candidateName)){
                    System.out.println("Invalid Name");
                    System.out.println("Re enter the details");
                    init();
                }
                System.out.println("Enter the Candidate Mobile No");
                String mobileNo=scanner.next();
                if(!interviewPanelModel.validateMobileNo(mobileNo)){
                    System.out.println("Invalid Mobile Number");
                    System.out.println("Re enter the details");
                    init();
                }
                System.out.println("Enter the Current Location");
                String location=scanner.next();
                System.out.println("Enter the Status of Interviwer");
                String candidateStatus=scanner.next();
                LocalDate inDate=LocalDate.now();
                LocalTime inTime=LocalTime.now();

                interviewPanelModel.candidateAdd(candidateId, candidateName, mobileNo, location,candidateStatus, inDate, inTime);

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
                LocalDate outDate=LocalDate.now();
                LocalTime outTime=LocalTime.now();
                interviewPanelModel.candidateOutUpdate(candidateId, outDate, outTime);

            }else if(choice==5){
                List<Candidates> candidates= interviewPanelModel.todayCandidateView();
                for(Candidates c:candidates){
                    System.out.println(c);
                }
            }
            else if(choice==6){
                loginView.passwordReset();
            }
            else if(choice==7){
                System.out.println("Logout Successfully");
                System.exit(0);
            }else{
                System.out.println("Bad choice");
            }
        }


    }
}

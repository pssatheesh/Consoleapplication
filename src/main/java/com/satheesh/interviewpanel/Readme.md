# Interview Panel
## Overview
Developed a Console application for HR Floor Admin to stores and manage the Candidates details. It is useful to store the candidates and the helpful to conduct a inteview smoothly to that Organisation.

## Type of Application: B2B
- Target Audience: Admin
- Development Time: 3 days
- Tech stack: Using Java Programming language and Ecilipse IDE
## Features:
- Admin login page
- Form to interviewer (name, mobile number, address, purpose, In date & time)
- To store the details in queue and the status are updated to delete the details
- When the queue is zero, the interview process will finished
- Status: goto round1 /round2/round3 
- All the details are stored in database
- To create a queue to store the details of interviewer
- 
## Model classes:
### Credentials
- userId: String
-	password: long
### Admin:
-	Name: String
-	userId: String
-	emailId: String
-	address: String

### Candidate management
#### Candidate add:
- candidateEntryId: string (company provided id no)
- candidateName: string
- candidateEmailId: string
- candidateIdProof: string
- purpose: string
- address: string
- status: string
- inDate: string
- inTime: string
- candidates: Queue< CandidateEntryId>
 
#### Candidate update:
- status: string
- outDate: string
- outTime: string
- Candidate remove:
- candidateEntryId: string (company provided id no)
- candidateName: string

### Admin login page
<img width="403" alt="I1" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/e3dbce94-7f3b-41aa-9f83-df381ada5b3f">

### Add Candidate
<img width="386" alt="I2" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/3a44e9c8-3fdc-4073-9024-379765903acf">

### View List of candidates
<img width="692" alt="I3" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/7823f844-985a-4a2a-9210-d8d43504ad7a">

### Update status of candidates
<img width="650" alt="I4" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/1c8851ce-70e6-4d1c-bcbc-e67d06ab267e">

### Update out time of candidates
After Update the outtime the id will deleted autoatically
<img width="410" alt="I5" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/18474f03-292a-4088-b02a-f3f03e1fefd1">

### View today interview candidate details and Logout
<img width="743" alt="I6" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/f9e1026b-a800-4c10-8d11-72f42d62d6a3">




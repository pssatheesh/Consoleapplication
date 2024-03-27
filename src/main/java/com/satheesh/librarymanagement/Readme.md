## Library Management
Type of Application: B2C
Target Audience: Admin/customer
Development Time: 3 days
Tech stack: Using Java Programming language and Ecilipse IDE
Features:
### Admin:
- Library setup 
- Admin user Login
- Books Add/Remove/update 
- New account creation for customer 

### Customer:
- Search and list available books
- Request a book
- Overdue books of his/her own
- Favourite books
- Managing account 
- Overdue books of all customers 



## Model Classes:
### Library
- Name: String
- LibraryId: String
- phoneNo: long
- emailId: String
- address: String

### Credentials
- userId: String
- password: long

### Book View
- Name: String
- Author: string
- Publication: string
- bookId: int
- availabilityCount: int
- volume: int

### Book Add
- bookName: String
- bookId: int;
- Publication: string
- Author: string
- volume: int

### Book Remove
- bookId: int
- bookName: string

### User
-	userId: int
-	username: string
-	phoneNo: long
-	emailId: String
-	address: string
-	govtIdProof: String
  
### User Remove
-	userId: int
	
### Issue Book:
- userId: int
- bookId: int
- bookCount: int
- date: LocalDate
 
 ### Return Book
 - bookId: int
 - userId: int
- Automatically return the system using Localdate function

 ### Flow Chart
 ![Library management flowchart](https://github.com/pssatheesh/Consoleapplication/assets/90780077/567b5307-003f-4d92-9ad3-ef844f3ee7f5)

### Login Page
<img width="475" alt="1" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/9c098bcf-72ce-4cdf-a423-ba847cc6a313">

### Add the Books in Library
<img width="538" alt="2" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/ab4e8dad-00a7-44c7-9eae-88f60458539a">

### View the Books in Library
<img width="533" alt="3" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/e3b77796-9c37-484e-9662-a8e4deaefc01">

### Main Menu and User Menu
<img width="410" alt="4" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/603508fe-99f6-4566-b219-524e818aa186">

### Add the user in the library
<img width="454" alt="5" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/de4249b1-3c63-4bac-84db-94e6d627c691">

### Logout the application and Exit
<img width="342" alt="6" src="https://github.com/pssatheesh/Consoleapplication/assets/90780077/00c6b422-947b-4c12-9e53-d0ec0247a682">



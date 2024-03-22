Library Management System
Type of Application
Business-to-Customer (B2C)

Target Audience
Admin and Customer

Development Time
3 days

Tech Stack
Java Programming language, Eclipse IDE

Features
Admin (P1 - 1.5 days)
Library Setup: Allows setting up library information.
Admin User Login: Authentication for admin users.
Books Add/Remove/Update: Functionality to add, remove, and update books.
New Account Creation for Customer: Allows creating new customer accounts.
Customer (P2 – 1.5 days)
List Available Books: Enables customers to search for and list available books.
Managing Account: Enables customers to manage their account details.
Overdue Books of All Customers: Allows viewing overdue books of all customers.
Model Classes
Library
Name: String
LibraryId: String
PhoneNo: long
EmailId: String
Address: String
AdminUsers: List
Credentials
UserId: String
Password: String
Admin
Name: String
UserId: String
EmailId: String
Book View
Name: String
Author: String
Publication: String
Id: int
Availability: Boolean
Volume: int
Book Add
BookName: String
BookId: int
Publication: String
Author: String
Volume: int
Book Remove
BookId: int
User
UserId: int
Username: String
PhoneNo: String
EmailId: String
Address: String
GovtIdProof: String
User Remove
UserId: int or Username: String or PhoneNo: String
This document outlines the key features, target audience, development timeline, tech stack, and model classes for a Library Management System developed using Java programming language and Eclipse IDE.
<img src="C:\Users\Lucky Dell\Pictures\Screenshots\Library Management">


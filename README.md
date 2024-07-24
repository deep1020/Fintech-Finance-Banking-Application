# Fintech-Finance-Banking-Application

Welcome to the Fintech Finance Banking Application repository! This project is a comprehensive banking application developed to handle various banking operations such as account management, transactions, payments, deposit, withdrawn and more.

## Table of Contents

- [Project Overview](#projectoverview)
- [Features](#features)
- [Technologies Used](#technologiesused)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#apiendpoints)
- [Screenshots](#screenshots)
- [References](#references)

## Project Overview

The Fintech Finance Banking Application is designed to provide users with a seamless banking experience. It allows users to sign-in/login account with email verification, add new account for existing user, manage their finances, transfer money, check transaction and payment history, and perform other banking operations securely.

## Features
- User Registration and Authentication: Secure user registration and login functionality.
- Account Management: Create, update, and delete accounts.
- Transactions: View transaction history, view payment history, transfer money between accounts, deposit, and withdraw funds.
- Notifications: Email notifications for account verification and transaction alerts.
- Security: Session management (Logout when session expired) and CSRF protection (Generate random unique token).

## Technologies Used
- Backend: Java, Spring Boot
- Frontend: JSP, HTML, CSS, JavaScript, jQuery
- Database: MySQL
- Security: Spring Security, BCrypt
- Build Tool: Maven
- Version Control: Git

## Installation

Prerequisites
- Java 8 or higher
- Maven
- MySQL

Steps

1. Clone the repository to your local machine:
   ```sh
   git clone https://github.com/deep1020/Fintech-Finance-Banking-Application.git
   ```
2. Set up the database:
   - Create a MySQL database named Fintech_Finance_Database.
   - Update the database configuration in src/main/resources/application.properties.
3. Build the project:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```
## Usage

- Open a web browser (Google Chrome Proferred) and go to http://127.0.0.1:8076/ which will land to the home page.
- Register a new account or log in with an existing account.
- Navigate through the dashboard to manage accounts and perform transactions.

## Requirements

1.	Maven 3.0+
2.	IntelliJ IDEA
3.	JDK 1.8+
4.	MySQL Workbench
5.	Postman for testing
6.	Email for account verification

## API Endpoints

User Endpoints
- POST /register: Register a new user
- POST /login: Authenticate a user through email
- GET /logout: Logout a user

Account Endpoints
- GET /accounts: Get all accounts for a user
- POST /accounts: Create a new account
- PUT /accounts/{id}: Update account details
- DELETE /accounts/{id}: Delete an account

Transaction Endpoints
- GET /transactions: Get all transactions for a user
- POST /transactions/transfer: Transfer money between accounts
- POST /transactions/deposit: Deposit money into an account
- POST /transactions/withdraw: Withdraw money from an account

## Screenshots

### Home Page [http://127.0.0.1:8076/]
<img width="873" alt="Screenshot 2024-07-21 at 10 24 43 PM" src="https://github.com/user-attachments/assets/dac6e9b4-84a6-49e1-b157-bfafad653a24">

### Register user [http://127.0.0.1:8076/register]
<img width="891" alt="Screenshot 2024-07-24 at 9 39 44 AM" src="https://github.com/user-attachments/assets/dddddb7a-1877-4ba9-8179-c90ce80e778a">

### Login user [http://127.0.0.1:8076/login]
<img width="619" alt="Screenshot 2024-07-21 at 10 24 09 PM" src="https://github.com/user-attachments/assets/db1c6fb7-31b8-4071-a5b4-6572e73bbbce"> 

### User Authentication
<img width="627" alt="Screenshot 2024-07-21 at 10 33 17 PM" src="https://github.com/user-attachments/assets/437b2494-a871-4135-8824-3cbb9c934959">
<img width="1184" alt="Screenshot 2024-07-21 at 10 30 29 PM" src="https://github.com/user-attachments/assets/9c32683b-5b55-4132-8469-bc9cc473a346">

### Dashboard
<img width="1326" alt="Screenshot 2024-07-24 at 10 01 27 AM" src="https://github.com/user-attachments/assets/32d871d3-99cb-4e31-a3b9-43a72b6bdb84">

### Create New Account
<img width="386" alt="Screenshot 2024-07-24 at 10 11 34 AM" src="https://github.com/user-attachments/assets/716b8814-46ff-4a0f-b1d4-60ebc6d7967c">
<img width="1335" alt="Screenshot 2024-07-24 at 10 14 27 AM" src="https://github.com/user-attachments/assets/86d1b2d3-00fc-4eb9-8d08-0a95520b7bb5">

### Transaction Options
<img width="386" alt="Screenshot 2024-07-24 at 10 18 49 AM" src="https://github.com/user-attachments/assets/5f253de3-5d09-4737-8e0f-83c678d15a0b">

### Deposit
<img width="391" alt="Screenshot 2024-07-24 at 10 20 33 AM" src="https://github.com/user-attachments/assets/62786339-cf33-43e9-b938-ef69d86c3c1b">
<img width="1349" alt="Screenshot 2024-07-24 at 10 22 01 AM" src="https://github.com/user-attachments/assets/221d2051-3b4e-4a30-90ec-d2fc06943821">

### Withdrawn
<img width="387" alt="Screenshot 2024-07-24 at 10 30 01 AM" src="https://github.com/user-attachments/assets/115e6eea-ad5e-4be6-99d1-dadeba87c524">
<img width="1335" alt="Screenshot 2024-07-24 at 10 32 23 AM" src="https://github.com/user-attachments/assets/d49db236-a385-4635-b3fd-8447f56c688a">

### Transfer
<img width="389" alt="Screenshot 2024-07-24 at 10 33 37 AM" src="https://github.com/user-attachments/assets/18dbcb5a-59e4-4517-af1d-771a0b6262b1">
<img width="1349" alt="Screenshot 2024-07-24 at 10 34 06 AM" src="https://github.com/user-attachments/assets/c844d371-3d41-4e01-9e07-42b3f47e0d22">

### Payments
- Account Holder Name and Beneficiary Account Number should be exist to proceed payments
- Entered amount should be less than or equal to current balance in selected account
<img width="390" alt="Screenshot 2024-07-24 at 10 57 34 AM" src="https://github.com/user-attachments/assets/ad2a17e5-2f7a-479e-aa49-9ff2592c9ff1">
<img width="1342" alt="Screenshot 2024-07-24 at 10 59 07 AM" src="https://github.com/user-attachments/assets/950ec51a-acc2-4bdd-b3cb-d4fa42de9340">
<img width="1351" alt="Screenshot 2024-07-24 at 10 59 43 AM" src="https://github.com/user-attachments/assets/9984cd7e-80aa-497d-a5b9-2370ce966e63">


















## References

1. [Spring Boot Documentation] (https://spring.io/guides/gs/spring-boot)
2. [Spring Security Documentation] (https://spring.io/projects/spring-security)
3. [Maven Documentation] (https://maven.apache.org/guides/index.html)
4. [BCrypt Password Hashing] (https://www.mindrot.org/projects/jBCrypt/)
5. [Email verification] (https://www.javaguides.net/2023/08/banking-application-using-spring-boot.html)
6. [Banking Application using Spring Boot] (https://www.javaguides.net/2023/08/banking-application-using-spring-boot.html)























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
- [License](#license)

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

## References

1. [Spring Boot Documentation] (https://spring.io/guides/gs/spring-boot)
2. [Spring Security Documentation] (https://spring.io/projects/spring-security)
3. [Maven Documentation] (https://maven.apache.org/guides/index.html)
4. [BCrypt Password Hashing] (https://www.mindrot.org/projects/jBCrypt/)
5. [Email verification] (https://www.javaguides.net/2023/08/banking-application-using-spring-boot.html)
6. [Banking Application using Spring Boot] (https://www.javaguides.net/2023/08/banking-application-using-spring-boot.html)

## License

This project is licensed under the MIT License. See the LICENSE file for more details.






















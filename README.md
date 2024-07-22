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














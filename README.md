# User Login System - Secure Registration & Login API
This project is a backend service that provides an API for secure registration and login verification, focusing on password encryption and basic login authentication using Spring Security.

## Technology Stack
Framework: Spring Boot, Spring Security
Database: MySQL
Testing: JUnit
Dependency Management: Maven
### Main Dependencies
spring-boot-starter-web
spring-boot-starter-security
spring-boot-starter-data-jpa
mysql-connector-java

## Installation and Setup
After cloning the project, set up the database: create a MySQL database named user_login_system and configure the database connection details in application.properties.

## Starting the Project:
In the bash terminal, run:
./mvnw spring-boot:run

## API Endpoint Overview
### Registration
POST /api/users/register: Register a new user; the password will be stored encrypted.
### Login
POST /api/users/login: Authenticate login and return the result.

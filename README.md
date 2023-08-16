# freshnest

## Table of Contents

1. [Introduction](#introduction)
    - Purpose
    - Features
    - User Persona
2. [Prerequisites](#prerequisites)
    - Software Requirements
    - Database Setup
3. [Project Setup](#project-setup)
    - Java Project Creation
    - freshnest Dependencies
4. [Database](#database)
    - Entity-Relationship Diagram (ERD)
    - Database Tables
5. [Modules](#modules)
    - User Module
    - User follow connection
    - Chat Module
    - Invite Module
    - Still module
   
6. [Validations](#validations)
    - User Validations
    - Chat Validations
    - Invite Validations
    - Still Validations
7. [Testing](#testing)
    - Unit Testing
8. [Exception Handling](#exception-handling)
    - Common Error Messages
    - Exception Handling
9. [Future Improvements](#future-improvements)
    - Planned Features
    - Roadmap
10. [Resources](#resources)
    - External Libraries
    - References

## Introduction

### Purpose

Develop a social media platform to make happy the users by the features of Chat, Stories, Still and Invite.

### Features

- Add, Update, View, Delete,Search and List all Book.
- Register, Login, Update, Delete User.
- Borrow, Renew, Return and Check availability of a Book.

### User Persona

- User
- Admin

## Prerequisites

### Software Requirements

- Java Development Kit (JDK)
- MySQL Database Server
- Integrated Development Environment

### Database Setup

- Table scripts: [Script](database_setup.sql)

## Project Setup

### Java Project Creation

- Create a new Java project
- Set up a MySQL database

### Library Dependencies

- JDBC,
- MySQL Connector,
- JUnit,

## Database

### Entity-Relationship Diagram (ERD)

[![HDWW5Qf.md.png](https://iili.io/HDWW5Qf.md.png)](https://freeimage.host/i/HDWW5Qf)
### Database Tables

#### Table: users

| Field           | Type          | Null | Key | Default           | Extra |
|-----------------|---------------|------|-----|-------------------|-------|
| user_id         | INT           | NO   | PRI | auto_increment    |       |
| firstname       | varchar(100)  | NO   |     |                   |       |
| lastname        | varchar(100)  | NO   |     |                   |       |
| username        | varchar(100)  | NO   |     |                   |       |
| email           | varchar(100)  | NO   |     |                   |       |
| mobile_number   | bigint        | NO   |     |                   |       |
| password        | varchar(100)  | NO   |     |                   |       |
| gender          | varchar(10)   | NO   |     |                   |       |
| nationality     | varchar(50)   | NO   |     |                   |       |
| dob             | date          | NO   |     |                   |       |
| age             | INT           | NO   |     |                   |       |
| registered_date | timestamp     | NO   |     | CURRENT_TIMESTAMP |       |
| isDelete        | tinyint(1)    | NO   |     | 1                 |       |
| isAdmin         | tinyint(1)    | NO   |     |                   |       |
| profile_image   | varchar(2048) | NO   |     |                   |       |

#### Table: chats

| Field               | Type         | Null | Key | Default        | Extra |
|---------------------|--------------|------|-----|----------------|-------|
| chat_participant_id | INT          | NO   | PRI | auto_increment |       |
| chat_type           | varchar(255) | NO   |     |                |       |       
| chat_name           | varchar(255) | NO   |     |                |       |

#### Table: chat_participants

| Field               | Type         | Null | Key | Default        | Extra |
|---------------------|--------------|------|-----|----------------|-------|
| chat_participant_id | INT          | NO   | PRI | auto_increment |       |
| chat_id             | INT          | NO   | PRI | auto_increment |       |       
| user_id             | INT          | NO   | PRI | auto_increment |       |


#### Table: chat_messages

| Field        | Type       | Null | Key | Default        | Extra |
|--------------|------------|------|-----|----------------|-------|
| message_id   | INT        | NO   | PRI | auto_increment |       |
| chat_id      | INT        | NO   |     |                |       |
| sender_id    | INT        | NO   |     |                |       |
| message      | TEXT       | NO   |     |                |       |
| message_time | TIMESTAMP  | NO   |     |                |       |

#### Table: fresh_still

| Field        | Type          | Null   | Key | Default        | Extra |
|--------------|---------------|--------|-----|----------------|-------|
| still_id     | INT           | NO     | PRI | auto_increment |       |
| user_id      | INT           | NO     |     |                |       |
| still_url    | varchar(2048) | NO     |     |                |       |
| still_name   | varchar(255)  | NO     |     |                |       |
| still_date   | DATE          | NO     |     |                |       |
| still_time   | TIME          | NO     |     |                |       |
| is_favourite | tinyint(1)    | NO     |     |                |       |
| is_delete    | tinyint(1)    | NO     |     |                |       |
| is_update    | tinyint(1)    | NO     |     |                |       |


#### Table: fresh_invite

| Field              | Type          | Null | Key | Default        | Extra |
|--------------------|---------------|------|-----|----------------|-------|
| invite_id          | INT           | NO   | PRI | auto_increment |       |
| user_id            | INT           | NO   |     |                |       |
| invite_type        | varchar(255)  | NO   |     |                |       |
| profile_image      | varchar(2048) | NO   |     |                |       |
| invite_date        | DATE          | NO   |     |                |       |
| invite_time        | TIME          | NO   |     |                |       |
| special_person     | varchar(255)  | NO   |     |                |       |
| invite_slogan      | DATE          | NO   |     |                |       |
| invite_explanation | TIME          | NO   |     |                |       |
| is_delete          | tinyint(1)    | NO   |     |                |       |

#### Table: invite_react_details

| Field              | Type       | Null   | Key | Default        | Extra |
|--------------------|------------|--------|-----|----------------|-------|
| react_id           | INT        | NO     | PRI | auto_increment |       |
| invite_id          | INT        | NO     |     |                |       |
| reactor_id         | INT        | NO     |     |                |       |
| is_accept          | TINYINT(1) | NO     |     |                |       |
| is_like            | TINYINT(1) | NO     |     |                |       |
| id_dislike         | TINYINT(1) | NO     |     |                |       |
| invite_message     | TEXT       | NO     |     |                |       |

## Modules

### User Module :

- Add a user:
    - Allows to register new users.
- View user details: 
    - Display detailed information about a specific user when selected.
- Update user details:
    - Enables to modify user information such as name, password, etc.
- Remove a user:
    - Allows to remove a user.

### Chat Module :

- Send chats: 
    - Allow user to send chats to their friends.
- View chats:
    - Display specify group chats conversation when they selected.
- Update chat details:
    - Enable to modify chat conversation.
- Remove a chat: 
    - Allows to remove a chat.
- Search user:
    - Enables to find user's friends by the username.

### Still Module :

- Take a still:
    - Allow users to take still.
- View a still:
    - Display the user taken still when they selected.
- Update still:
    - Enable to modify stills.
- Delete still:
    - Allow to remove a still.
- Filter still:
    - Enables to filter the stills by the time period.

### Invite Module :

- Create a invite:
    - Allow users to create invite.
- View a still:
    - Display the invite details when they selected.
- Update still:
    - Enable to modify invite details.
- Delete still:
    - Allow to remove a invite.


## Validations

### User Validations :

- First name Validation
- Last name Validation
- User name Validation
- Email Validation
- Password Validation
- Gender Validation
- Mobile number Validation
- Nationality Validation
- Date of Birth Validation
- Profile Image Url Validation

### Chat Validations :

- Chat text Validation
- Chat type Validation

### still Validations :

- Still image url Validation
- Still name Validation
- Still date Validation
- Still time validation

### invite Validations :

- invite image url Validation
- invite name Validation
- invite date Validation
- invite time Validation
- invite explanation Validation
- invite message Validation


## Testing

### Unit Testing

- UserServiceUnitTest
    - Register, Login, Update, Delete and List all Users.
- BookServiceUnitTest
    - Add, Update, View, Delete and List all Books
- BorrowServiceUnitTest
    - Borrow, Return, Borrow History and List all Borrows
- UserValidationUnitTest
- BookValidationUnitTest
- BorrowValidationUnitTest

## Exception Handling

### Custom Exceptions :

- DAO Exception
- Validation Exception
- Service Exception

### Common Error Messages :

- Name cannot be null or empty
- Invalid Password
- Invalid email address
- Invalid phone number
- User already exists
- Book not found
- Maximum borrow limit reached
- Book already borrowed
- Invalid book id
- Failed to update user information
- Failed to update book information
- Failed to return the book
- Database connection error

## Future Improvements

### Planned Features

- Book Recommendations
    - Implement a recommendation engine that suggests books based on a user's reading history and preferences.
- Book Reviews and Ratings
    - Enable users to leave reviews and ratings for books they have read.
- Advanced Book Search
    - Enhance the book search functionality with advanced filters, sorting options, and the ability to search within
      specific genres or authors.

### Roadmap

- QR Code Integration
    - Implement QR code generation and scanning for easy book check-ins and check-outs in physical libraries.
- Data Analytics and Insights:
    - Integrate data analytics tools to gather insights on user behavior, popular book genres, and borrowing patterns.

## Resources

### External Libraries

- JDBC:
    - Java Database Connectivity library used for database interactions.
- MySQL Connector:
    - JDBC driver for connecting to the MySQL database.
- JUnit:
    - A testing framework for writing and running unit tests in Java

### References

- Java Platform, Standard Edition Documentation: https://docs.oracle.com/javase/8/docs/api/
- MySQL Documentation: https://dev.mysql.com/doc/
- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/

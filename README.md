
# Expense Tracker API

A simple REST API created using Spring Boot and MySql.

## Run Locally

Clone the project

```bash
  git clone https://github.com/arsan13/expense-tracker-api.git
```

Go to the project directory

```bash
  cd expense-tracker-api
```

Create a database

```bash
  CREATE DATABASE database_name
```

Configure database properties in "application.properties" file as per your need

```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
  spring.datasource.username=root
  spring.datasource.password=
```

Build and Run the app

```bash
  mvn spring-boot:run
```

The app will start running at http://localhost:8080


## Swagger - API Documentation
- [UI format](https://expense-tracker-api-fm78.onrender.com/swagger-ui.html) 
- [JSON format](https://expense-tracker-api-fm78.onrender.com/v2/api-docs)

Cilck [here](https://swagger.io/) to know more about Swagger

## Explore REST APIs
  
### User Authentication

| Method        |         URL        | Description   | Return          |      
| ------------- | ------------------ | ------------- | --------------- |
| POST          | api/users/register/ | Sign-up       | JSON Web Token  |
| POST          | api/users/login/    | Login         | JSON Web Token  |               

### Categories

| Method        |         URL        | Description   | Return          |      
| --- | --- | --- | --- |
| GET | api/categories/ | Get all categories | Array of JSON objects |
| GET | api/categories/{id} | Get a category by id | Single JSON object |            
| POST | api/categories/ | Create a new category | Created JSON object |
| PUT | api/categories/{id} | Update an existing category | Updated JSON object |
| DELETE | api/categories/{id} | Delete a category | Success message |

### Transactions

| Method        |         URL        | Description   | Return          |      
| --- | --- | --- | --- |
| GET | api/categories/{cid}/transactions/ | Get all transactions of "cid" category | Array of JSON objects |
| GET | api/categories/{cid}/transactions/{tid} | Get a single transaction by "tid" of category "cid" | Single JSON object |            
| POST | api/categories/{cid}/transactions/ | Insert a new transaction for the category "cid" | Created JSON object |
| PUT | api/categories/{cid}/transactions/{tid} | Update an existing transaction | Updated JSON object |
| DELETE | api/categories/{cid}/transactions/{tid} | Delete a transaction | Success message |

> **_NOTE:_**  
The endpoints of "Categories" and "Transactions" are restricted. To access those endpoints, use the token which is generated after logging-in as the value of the Bearer in the Authorization header as follows:  
**"Authorization: Bearer Token_id"**

## Sample Request Body

### User - Register
```bash
  {
    "firstName": "Thomas",
    "lastName": "Shelby",
    "email": "shelby@gmail.com",
    "password": "test123"
  }
```
### User - Login
```bash
  {
    "email": "shelby@gmail.com",
    "password": "test123"
  }
```

### Categories
```bash
  {
    "title": "Shopping",
    "description": "All shopping expenses in xyz mall"
  }
```

### Transactions
```bash
  {
    "amount": 4000,
    "note": "Spent higher than last time",
    "transactionDate" : "2021-19-09"
  }
```

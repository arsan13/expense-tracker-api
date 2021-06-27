
# Expense Tracker

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

Build and Run the app

```bash
  mvn spring-boot:run
```

The app will start running at http://localhost:8080


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
The endpoints of "Categories" and "Transactions" is only accessible to authenticated users. Use the generated token as the value of the Bearer in the Authorization header as follows:  *"Authorization: Bearer Token_id"*


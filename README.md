# StockExchange Project
This project does some CRUD operations with Stocks in a Stock Exchange. To do operations, first you must be a registered user. Basic Authentication is provided by Spring, user must login as "User" and with the password provided by Spring while project is running, you will find the password in terminal on start as follows:

![image](https://github.com/giginar/StockExchange/assets/75164709/259ed572-8105-4d14-8422-db9996d52448)

## Setup
- Clone the project
- Open the project on your IDE
- Navigate to the root of the project via command line
- Run "mvn clean install" on terminal
- Run "mvn spring-boot:run" to start the project


## Technologies
- Java 17
- Maven v3.8.2
- Spring Boot v3.2.5
- Spring security
- H2 Embedded DB
- Lombok

## Endpoints
- List one stockExchange with all the stocks (api/v1/stock-exchange/{name})
- Able to create a stock (api/ v1/stock)
- Able to add the stock to the stock exchange(api/v1/stock-exchange/{name})
- Able to delete the stock from the stock exchange (api/v1/stock-exchange/{name})
- Update the price of a stock (api/stock)
- Able to the delete the stock from the system (api/v1/stock)

## Additional Info
- Find Postman Collection in "StockExchange.postman_collection.json" file in main directory.

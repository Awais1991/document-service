# Document Service

Payment Service is a Java application developed using Spring Boot (version 3.2.2) and Java 21. It serves as a backend service for handling receipt management. Payment service communicates with this service and provides it the data to generates the receipt. The application utilizes an H2 database for data storage.

## Technologies

- Java 21
- Spring Boot 3.2.2
- H2 Database
- JUnit
- Swagger for API documentation
- Spring Boot Actuator for monitoring and managing application

## Features

1. **Add Receipt:** This API receives the data and persist it for document generation
2. **Receipt Generation::** Thymeleaf Templates: The service uses Thymeleaf templates to generate payment receipts in html format.

4. **Swagger Documentation:**
    - API documentation is available through Swagger for easy exploration and integration.
    - Accessible at [http://localhost:8083/document/swagger-ui/index.html#/](http://localhost:8083/document/swagger-ui/index.html#/).
### Spring Boot Actuator

- Monitor and manage the application in production with Spring Boot Actuator.
- Endpoints include health, metrics, info, and more.
- Accessible at [http://localhost:8084/document/actuator](http://localhost:8084/document/actuator).

## Setup

1. Clone the repository.
2. Configure your IDE or build tool for a Spring Boot application.
3. Run the application and access the Swagger documentation to explore the APIs.


## Endpoints

- **Payments:**
    - POST `/api/addReceipt` -This API receives the data and persist it for document generation
    - GET `/api/view-receipt/receiptId/{receiptId}` -This API is used for view receipt purpose in html format, it takes receipt id in url path
    - GET `/api/view-receipt/transaction/{transactionId}` -This API is used for view receipt purpose in html format, it takes transaction id in url path
# Getting Started

To get started with the project, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/Awais1991/document-service.git

2. Build Application:

   ```bash
   mvn clean install

3. Run Application:

   ```bash
   java -jar document-0.0.1-SNAPSHOT.jar

4. Access Swagger:

   ```bash
   http://localhost:8084/document/swagger-ui/index.html#/
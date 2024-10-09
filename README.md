# Assignment Application for Rational Data

This is a Spring Boot application developed as an assignment for the Rational Data company.

## Prerequisites

- Java 17

## Getting Started

### Build the Application

To build the application, navigate to the root directory of the project and run:

```sh
mvn clean package
```

### Run the Application
To start the application locally, use the following command:
```sh
mvn spring-boot:run
```

The application will start on http://localhost:8080.
if you want to run the application with a different port, you can change the port in the application.properties file.
```properties
server.port=8080
```

### Run tests
To run the tests, use the following command:
```sh
mvn test
```

## Application Functionality
This application is a service that navigates an imaginary robotic hover through an equally imaginary room via a REST api.

## API Documentation
The application includes Swagger UI for API documentation and testing. 
You can access the Swagger UI by navigating to http://localhost:8080/swagger-ui.html.

## Available Endpoints

### Clean the Room

**POST /hoover/clean**

Clean the room using the Hoover. Provide room dimensions, initial position, and dirt patches to clean the room.

#### Request
- **URL**: `/hoover/clean`
- **Method**: `POST`
- **Content-Type**: `application/json`
- **Request Body**:
  ```json
  {
    "roomSize": [5, 5],
    "coords": [1, 2],
    "patches": [[1, 0], [2, 2], [2, 3]],
    "instructions": "NNESEESWNWW"
  }


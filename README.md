# FX Data Warehouse 📊

The ClusteredData Warehouse is a robust FX deals data warehouse system built for Bloomberg, focusing on efficient deal import and validation. This system handles FX deal persistence with strict validation rules and a no-rollback policy.

![Project Status](https://img.shields.io/badge/Status-Production--Ready-green)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-green)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue)
![Coverage](https://img.shields.io/badge/Coverage-90%25-brightgreen)


## Features

### 1. **Data Ingestion**
- Accepts FX deal details via structured requests.
- Ensures seamless integration with external systems for data input.

### 2. **Validation Layer**
- Validates incoming data to ensure integrity.
- Checks for missing fields, incorrect formats, and other potential issues.

### 3. **Duplicate Prevention**
- Prevents the same deal from being imported more than once.
- Ensures data uniqueness and consistency.

### 4. **Persistence Layer**
- Stores data using **PostgreSQL**, a reliable and scalable relational database.
- Ensures data durability and easy retrieval.

### 5. **Error Handling**
- Implements robust error and exception handling mechanisms.
- Provides meaningful error messages for easier debugging and issue resolution.

### 6. **Logging**
- Uses proper logging mechanisms for monitoring and debugging.
- Logs are structured and informative, aiding in quick issue identification.

### 7. **Testing**
- Includes comprehensive unit tests with significant coverage.
- Ensures the reliability and correctness of the system.

### 8. **Deployment**
- Offers a **Dockerized** setup for easy deployment.
- Includes a sample file to help users get started quickly.

### 9. **Documentation**
- Provides detailed documentation in **Markdown** format.
- Covers setup, usage, and troubleshooting guides.

### 10. **Makefile Support**
- Includes a **Makefile** to simplify running the application.
- Streamlines common tasks such as building, testing, and deploying the system.


## Technologies Used

### Core Technologies
- Java 21
- Spring Boot 3.4.2
- PostgreSQL 16
- Docker & Docker Compose

### Development Tools
- Maven
- JUnit 5
- AssertJ
- Mockito
- SLF4J 


## Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/hamzalamin/progres-soft-test.git
   cd progres-soft-test
   ```
   
2. **Build the project using Maven:**
   ```bash
   mvn clean install
   ```
   
3. **Run the application:**
   ```bash
   docker-compose up --build
   ```


## Makefile Commands

The project includes a `Makefile` to simplify common tasks. Below are the available commands:

```bash
make up      # Start Docker containers (build and run the application)
make down    # Stop and remove Docker containers
make test    # Run all unit and integration tests
make clean   # Clean build files and remove temporary artifacts
```

## API Endpoints

### POST `/api/v1/deals`
    Accepts FX deal details and persists valid ones in the database.

#### Request
Request Body:
```json
{
  "id": "ABC1234",
  "fromCurrency": "MAD",
  "toCurrency": "USD",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}
```

Response:
```json
{
  "id": "ABC1234",
  "fromCurrency": "MAD",
  "toCurrency": "USD",
  "timestamp": "2024-01-01T10:00:00Z",
  "amount": 1000000.00
}
```

## Project Structure
```bash
  ├── src/
  │   ├── main/
  │   │   ├── java/
  │   │   │   └── com/progressoft/progressofttest/
  │   │   │       ├── controller/   
  │   │   │       ├── dto/          
  │   │   │       ├── entity/       
  │   │   │       ├── exception/    
  │   │   │       ├── mapper/       
  │   │   │       ├── repository/   
  │   │   │       ├── service/      
  │   │   │       └── ProgressoftTestApplication.java
  │   │   └── resources/           
  │   └── test/                    
  ├── compose.yml                  
  ├── Dockerfile                   
  ├── Makefile                     
  └── pom.xml  
```                    

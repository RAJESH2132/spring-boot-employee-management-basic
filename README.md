# Spring Boot Employee Management - Basic

This project demonstrates different approaches to implementing employee management in Spring Boot.

## Implementations Covered

The project contains multiple techniques for building REST APIs with employee data management:

1. **JPA with DAO Layer**
   * Direct JPA API implementation with custom DAO classes.
   * Manual implementation of CRUD operations.
   * Demonstrates low-level control over database operations.

2. **Spring Data JPA**
   * Simplified approach using Spring Data JPA repositories.
   * Automatic CRUD operations without writing boilerplate code.
   * Uses JpaRepository interface for quick development.

3. **Spring Data REST**
   * Automatic REST endpoint generation from JPA repositories.
   * Eliminates manual controller creation.
   * Provides out-of-the-box REST API with pagination and sorting.

## Branch Structure

Each implementation is available in a separate branch:

* `feat/jpa-api-dao` → Employee management using JPA API with DAO layer
* `feat/spring-data-jpa` → Simplified approach using Spring Data JPA
* `feat/spring-data-rest` → Automatic REST API generation with Spring Data REST
* `feat/openapi-swagger` → REST API documentation with OpenAPI/Swagger

Switch branches depending on the implementation you want to explore.

## Purpose of This Project

This project is intended for learning and understanding different approaches to building REST APIs in Spring Boot for employee management.

---

**Technology Stack:**
- Java 21
- Spring Boot 4.0.3
- Spring Data JPA
- Spring Data REST
- MySQL

**Database Configuration:**
- Server: localhost:3306
- Database: employee_directory
- Port: 8081
- REST API Base Path: /magic-api
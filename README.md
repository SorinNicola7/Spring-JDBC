# 🚗 Spring-Project3: Vehicle Database Persistence (Spring JDBC)

## 📌 Project Overview

This project is an extension of a vehicle management system, enhanced with database persistence using Spring JDBC. It demonstrates how to move from in-memory object handling to persistent storage using a MySQL database.

The application is built with the Spring Framework and focuses on managing vehicle data through database operations.

---

## 🎯 Objective

* Store and manage vehicle data in a relational database
* Use Spring JDBC for database interaction
* Configure database connectivity using Spring beans

---

## 🛠️ Technology Stack

* **Language:** Java SE 21
* **Framework:** Spring Framework 4.2.2.RELEASE

  * Modules:

    * spring-jdbc
    * spring-tx
    * spring-context
    * spring-aop
    * spring-beans
    * spring-core
    * spring-expression
* **Database:** MySQL
* **Driver:** mysql-connector-j-8.0.33
* **Logging:** commons-logging-1.2
* **IDE:** Eclipse

---

## ⚙️ Configuration & Database Setup

The application is configured using `beans_masini.xml`.

### 🔹 1. Data Source Configuration

The application connects to a local MySQL database using:

* **Driver Class:** `com.mysql.cj.jdbc.Driver`
* **URL:** `jdbc:mysql://localhost:3306/proiect_spring`
* **Username:** `root`
* **Password:** 'root'

Spring uses `DriverManagerDataSource` to manage the connection.

---

### 🔹 2. Business Logic Layer

* **Class:** `cerinta3.GestiuneMasini`
* **Responsibility:**

  * Handles database operations (insert, update, query, delete)
  * Uses injected `dataSource` to interact with the database

---

## 📂 Project Structure

```bash
src/
  cerinta3/
    GestiuneMasini.java

bin/
  (compiled .class files)

beans_masini.xml
  (Spring configuration file)
```

---

## 🚀 How to Run

1. **Create the database**

   * Open MySQL
   * Create a database:

     ```sql
     CREATE DATABASE proiect_spring;
     ```

2. **Import the project into Eclipse**

   * File → Import → Existing Projects into Workspace

3. **Configure dependencies**

   * Update library paths from `.classpath` (they may contain local absolute paths)
   * Ensure all Spring JARs and MySQL connector are correctly linked

4. **Run the application**

   * Execute the main class (if available) or test methods
   * Verify database operations (insert/select/update/delete)

---

## 📚 Learning Outcomes

* Working with Spring JDBC
* Configuring a DataSource in Spring
* Connecting Java applications to MySQL
* Performing database operations using Spring
* Understanding persistence layer basics

---

## 🔧 Possible Improvements

* Replace XML configuration with Java-based configuration
* Migrate to Spring Boot
* Use a connection pool (e.g., HikariCP)
* Implement DAO and Service layers
* Add REST API for external access

---

## 📎 Notes

This project is part of a series focused on learning Spring Framework concepts, including Dependency Injection and database integration. It builds upon previous projects by introducing persistence and database interaction.

---

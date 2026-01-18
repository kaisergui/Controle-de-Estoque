# 📦 Controle de Estoque

![Java](https://img.shields.io/badge/Java-Desktop-blue?style=flat-square\&logo=java)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-orange?style=flat-square)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square\&logo=mysql)
![Status](https://img.shields.io/badge/Status-Learning%20Project-yellow?style=flat-square)

**Controle de Estoque** is a **desktop inventory management system** built with **Java**, **Java Swing**, and **MySQL**. The project focuses on applying **object-oriented programming**, desktop UI development, and database integration.

---

## 🚀 Project Goals

* Practice **Java OOP fundamentals**
* Build a functional **desktop application** using Java Swing
* Implement **CRUD operations** with database persistence
* Understand the basics of **DAO and service layers**
* Serve as a learning project and portfolio reference

---

## 🧱 Architecture Overview

The application follows a simple layered structure:

* **UI Layer** – Java Swing screens and user interaction
* **Service Layer** – Business logic and validations
* **DAO Layer** – Database access using JDBC
* **Model Layer** – Domain entities (Product, etc.)

This structure helps maintain separation of concerns and code organization.

---

## 🧰 Tech Stack

### Desktop Application

* Java
* Java Swing
* JDBC

### Database

* MySQL

### Tools

* NetBeans / IntelliJ / Eclipse
* Git & GitHub

---

## ✨ Features

### Core Features

* Register products
* Update product information
* Remove products
* Control product stock quantity

### Technical Features

* Java Swing graphical interface
* MySQL database persistence
* DAO pattern for database operations
* Organized package structure

---

## 📂 Project Structure

```
Controle-de-Estoque
 ├── src
 │   ├── model
 │   ├── dao
 │   ├── service
 │   ├── ui
 │   ├── util
 │   └── Main.java
```

---

## ⚙️ How to Run the Project

### Prerequisites

* Java JDK 11 or higher
* MySQL Server
* IDE with Java Swing support

### Steps

```bash
# Clone the repository
git clone https://github.com/kaisergui/Controle-de-Estoque.git

# Open the project in your IDE
# Configure the MySQL connection in the DAO layer
# Run the Main class
```

Create the database manually:

```sql
CREATE DATABASE controle_estoque;
```

---

## 🧪 Testing

* Manual testing via the desktop UI
* Future improvement: unit tests for service layer

---

## 🔮 Roadmap

* Login and user authentication
* Inventory reports
* Low-stock alerts
* Export data to CSV / Excel
* UI improvements

---

## 👨‍💻 Author

**Guilherme Kaiser**
Java Backend Developer

* GitHub: [https://github.com/kaisergui](https://github.com/kaisergui)
* LinkedIn: [https://www.linkedin.com/](www.linkedin.com/in/guilhermekaiserds)

---

⭐ *This project was created for learning purposes and continuous improvement in Java development.*

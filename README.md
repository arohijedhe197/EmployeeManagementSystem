# 👩‍💼 Employees Management System - Spring Boot REST API

A simple and extensible **Spring Boot** project that provides user authentication and full CRUD operations for managing employees.

This project demonstrates:
- User registration and login (via JWT or basic token approach)
- Creating, updating, deleting, and retrieving employee data
- RESTful design with Spring Boot and standard best practices

---

## 🚀 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security (JWT or token-based authentication)
- MySQL or H2 Database
- Maven
- Postman (for testing)

---

## 📁 Project Structure
src/main/java/com/employee/employeeManagementSystem/
│
├── core/
│ ├── controller/
│ │ ├── AuthController.java
│ │ └── EmployeeController.java
│ ├── entity/
│ │ ├── User.java
│ │ └── Employee.java
│ ├── model/
│ │ └── AuthRequest.java
│ └── service/
│ ├── IUserService.java
│ └── IEmployeeService.java





---

## 🔐 Authentication APIs

Base URL: `/api/auth`

| Method | Endpoint             | Description                    |
|--------|----------------------|--------------------------------|
| POST   | `/api/auth/register` | Register a new user            |
| POST   | `/api/auth/login`    | Login and get auth token       |

### 🙎‍♂️ Employee APIs

Base URL: `/api/employees`

| Method | Endpoint              | Description                 |
| ------ | --------------------- | --------------------------- |
| GET    | `/api/employees`      | Retrieve all employees      |
| GET    | `/api/employees/{id}` | Get a single employee by ID |
| POST   | `/api/employees`      | Add a new employee          |
| PUT    | `/api/employees/{id}` | Update existing employee    |
| DELETE | `/api/employees/{id}` | Delete employee by ID       |

### ✅ Future Improvements
Add role-based access control (Admin/User)

Swagger UI documentation

Dockerize the application

Frontend UI with Angular/React


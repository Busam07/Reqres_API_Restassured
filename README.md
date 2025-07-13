# Reqres API Automation Framework (REST Assured + Java)

This project is a REST API test automation framework built using **REST Assured** and **Java**, targeting the public API service [Reqres.in](https://reqres.in/). It is designed to demonstrate foundational API testing capabilities and will be extended into a complete test suite with reporting.

---

## 🧪 Project Purpose

The goal of this project is to:
- Practice and showcase REST API automation using Java and REST Assured
- Validate CRUD operations on a demo API
- Learn schema validation, assertions, data-driven testing, and CI pipeline integration

---
**📌 Project Description** 
Reqres API Automation Framework is a REST API test suite built using Java, REST Assured, and TestNG to validate the core functionality of the public Reqres.in API. The project currently covers GET endpoints for user retrieval, including status code validation and basic field assertions. It follows a modular Maven structure and serves as the foundation for future enhancements such as POST/PUT/DELETE testing, schema validation, reporting, and CI/CD integration using Jenkins or GitHub Actions.

## ✅ Current Features

### Implemented:
- Basic setup using Maven and REST Assured
- Sample GET request test cases for:
  - `GET /users?page=2` – list users
  - `GET /users/{id}` – single user
  - 'delete/user/{id}' - delete user
- Status code and response body field validation
- Simple test runner using TestNG

---

## 🧩 Planned Enhancements

### Next Steps:
- Add **POST**, **PUT**, and **DELETE** test cases for user creation and updates
- Implement **JSON Schema validation**
- Add **negative test cases** (e.g., invalid IDs, malformed payloads)
- Integrate with **Newman** and **Postman Collection** export
- Add **Allure or ExtentReports** for visual results


---

## 🛠 Tech Stack

- **Programming Language**: Java  
- **API Testing Library**: REST Assured  
- **Build Tool**: Maven  
- **Test Framework**: TestNG  
- **Version Control**: Git, GitHub

---

## 📁 Project Structure
```text
Reqres_API_Restassured/
├── src/
│   └── test/
│       └── java/
│           └── api/
│               └── GetUsersTest.java
├── pom.xml
└── README.md

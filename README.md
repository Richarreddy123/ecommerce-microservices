# E-Commerce Microservices (Spring Boot)

This project demonstrates a simple **E-commerce backend using Microservices Architecture** built with **Spring Boot**.

The system contains three independent services:

- Product Service
- Inventory Service
- Order Service

Each service runs independently and communicates using REST APIs.

---

## Architecture

Client (Postman)

Product Service → Inventory Service → Order Service

Ports used:

Product Service → 8081  
Inventory Service → 8082  
Order Service → 8083  

---

# Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- REST APIs
- Postman
- IntelliJ IDEA

---

# Microservices

## Product Service

Port: **8081**

Responsible for managing products.

### Create Product

POST /products

Example Request

```json
{
  "name": "iPhone 15",
  "price": 999.99,
  "quantity": 50
}

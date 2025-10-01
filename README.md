# 🛒 E-Commerce Web Application

[![GitHub license](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Vue.js](https://img.shields.io/badge/Vue.js-2.6-brightgreen.svg)](https://vuejs.org/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-2.7.5-green.svg)](https://spring.io/projects/spring-boot)
[![H2 Database](https://img.shields.io/badge/H2-Database-blue.svg)](https://www.h2database.com/)
[![GitHub stars](https://img.shields.io/github/stars/hadhoud55/My-Ecommerce?style=social)](https://github.com/hadhoud55/My-Ecommerce/stargazers)

A **full-stack e-commerce web application** built with **Spring Boot (backend)** and **Vue.js (frontend)**.  
The app features **JWT authentication**, **role-based access control** (Admin/User), product management, and a shopping cart system.  
It uses an **H2 in-memory database** for easy setup.

---

## ✨ Features

- 🔐 **Authentication & Security**  
  - JWT-based login & registration with Spring Security  
  - Role-based access: Admin / User  

- 👥 **Roles**  
  - **Admin** → manage users & products  
  - **User** → browse products, add to cart, checkout  

- 📦 **Entities**  
  - `User` → account info, roles, profile image (optional)  
  - `Product` → id, name, description, category, price  
  - `Cart` → composite key (`user_id`, `product_id`) with quantity  

- 💻 **Frontend (Vue.js)**  
  - Product listing & details  
  - User authentication (login/register)  
  - Cart management (add, update, remove items)  
  - Admin dashboard for managing products & users  

- ⚙️ **Backend (Spring Boot)**  
  - RESTful APIs for users, products, and cart  
  - H2 in-memory database (no installation required)

---

## 🛠️ Tech Stack

**Backend**: Spring Boot, Spring Security, JWT, H2 Database  
**Frontend**: Vue.js (Vue CLI), Axios, Bootstrap  

---

## 🚀 Getting Started

### 🔧 Backend Setup

1. Navigate to the backend folder:  
   ```bash
   cd Backend
   ````
   
   
2. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ````
    
    
3. Access H2 console: http://localhost:8080/h2-console
    - JDBC URL: jdbc:h2:mem:testdb
    - Username: sa
    - Password: (leave blank)

### 🎨 Frontend Setup

1. Navigate to the frontend folder:
    ```bash
    cd Frontend
    ````


2. Install dependencies:
    ```bash
    npm install
    ````

3. Run the development server:
    ```bash
    npm run serve
    ````


4. Open the app in your browser: http://localhost:8080

   
---

## 📌 Roadmap

- ✅ JWT authentication
- ✅ Role-based access (Admin/User)
- ✅ Cart functionality
- ✅ Product management (CRUD by Admin)
- ✅ User management (CRUD by Admin)
- ✅ H2 in-memory database integration
- ✅ Frontend with Vue.js and Bootstrap
- ⏳ Orders & Payments integration
- ⏳ Search and filter products
- ⏳ Pagination for product listings
- ⏳ Product images support
- ⏳ Order history for users
- ⏳ Checkout process with cart summary
- ⏳ Deployment (Docker/Cloud)
- ⏳ Testing & code optimization

---

## 🤝 Contributing

Contributions are welcome! Please fork this repo and submit a pull request.

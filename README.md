# 🛒 E-Commerce Web Application

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

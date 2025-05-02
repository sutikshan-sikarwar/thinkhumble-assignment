# Thinkhumble – Backend Assignment

This is a Spring Boot backend application built as part of the Thinkhumble recruitment assignment. It provides REST APIs for user registration, login using JWT authentication, and fetching real-time stock quotes using the Alpha Vantage API.

---

## 🚀 Deployed API (Render)

You can access the deployed API here:  
🔗 https://thinkhumble-assignment.onrender.com

---

## 💡 Features

- User registration and login using JWT
- Protected APIs for fetching stock quotes
- Real-time data fetched from Alpha Vantage API
- MongoDB used for storing user credentials
- Dockerized for easy deployment

---

## 📦 Tech Stack

- Java 17
- Spring Boot 3
- MongoDB Atlas
- Spring Security with JWT
- Alpha Vantage API
- Docker
- Deployed on Render

---

## 🔐 Authentication

- Register a new user via `/auth/register`
- Login via `/auth/login` to get a JWT token
- Pass the token in the `Authorization` header as `Bearer <token>` to access secured endpoints

---

## 🧪 Sample API Usage

### 1. Register

```
POST /auth/register
Content-Type: application/json

{
  "username": "john",
  "password": "secret123"
}
```

---

### 2. Login

```
POST /auth/login
Content-Type: application/json

{
  "username": "john",
  "password": "secret123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}
```

---

### 3. Get Stock Quote

```
GET /api/quotes/AAPL
Headers:
Authorization: Bearer <your_token_here>
```

---

## 🐳 Docker Instructions

```bash
# Build the app
mvn clean package -DskipTests

# Build Docker image
docker build -t thinkhumble-backend .

# Run the container
docker run -p 5454:5454 thinkhumble-backend
```

---

## 📁 Project Structure

- `controller/` → API endpoints
- `model/` → User and Quote models
- `repository/` → MongoDB repositories
- `security/` → JWT filters and user auth logic
- `config/` → Security config
- `service/` → External API service (Alpha Vantage)
- `client/` → Stock API client
- `resources/` → `application.properties`, etc.

---

## 🌍 Environment Variables (used in Render)

- `JWT_SECRET` → Secret key for JWT
- `SPRING_DATA_MONGODB_URI` → MongoDB Atlas URI
- `ALPHA_VANTAGE_API_KEY` → Your Alpha Vantage API key
- `PORT` → 5454 (or default 8080)

---

## ✍️ Author

Sutikshan Sikarwar  
B.Tech CSE, VIT Bhopal
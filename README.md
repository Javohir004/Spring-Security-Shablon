# 🔐 Spring Security + JWT Authentication Template

A ready-to-use authentication and authorization template for Spring Boot projects.
Built with JWT token-based security and professional error handling.

---

## ✨ Features

- ✅ Spring Boot 3.2.1 + Spring Security 6
- ✅ JWT Authentication (Access & Refresh Token)
- ✅ Role-based Access Control (USER, ADMIN)
- ✅ Global Exception Handling
- ✅ PostgreSQL + JPA
- ✅ Swagger UI Integration
- ✅ BCrypt Password Encryption

---

## 🛠️ Tech Stack

| Category | Technologies |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 3.2.1, Spring Security 6, Spring Data JPA |
| Security | JWT (jjwt 0.11.5), BCrypt |
| Database | PostgreSQL |
| Documentation | Swagger / OpenAPI 3 |
| Build | Maven |
| Other | Lombok |

---

## 📚 API Endpoints

### 🔓 Public
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and receive JWT token |
| GET | `/api/test/public` | Public test endpoint |

### 🔒 Protected
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/test/user` | Accessible by USER role |
| GET | `/api/test/admin` | Accessible by ADMIN role only |

📖 Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 🚨 Error Handling

All errors return a standardized JSON response:

```json
{
  "timestamp": "2024-02-04 10:30:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Invalid email or password",
  "path": "/api/auth/login"
}
```

| Status | Meaning |
|---|---|
| 400 | Validation error |
| 401 | Wrong password / Token expired |
| 403 | Access denied |
| 404 | User not found |
| 409 | Email already registered |

---

## 🚀 Quick Start

**1. Create the database:**
```sql
CREATE DATABASE test;
```

**2. Configure `application.properties`:**
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/test
spring.datasource.username=your_username
spring.datasource.password=your_password

jwt.secret=your_secret_key
jwt.expiration=86400000
```

**3. Run the application:**
```bash
mvn spring-boot:run
```

**4. Open Swagger UI and start testing:**
```
http://localhost:8080/swagger-ui.html
```

---

## 📫 Contact

- GitHub: [Javohir004](https://github.com/Javohir004)

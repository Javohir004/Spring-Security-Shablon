🔐 **Spring Security + JWT Authentication Template**
Spring Boot loyihalarida autentifikatsiya va avtorizatsiya uchun tayyor shablon. JWT token asosida ishlaydi va professional error handling bilan ta'minlangan.

━━━━━━━━━━━━━━━━━━━━━━━━━━━━
✨ **XUSUSIYATLAR**

✅ Spring Boot 3.2.1 + Spring Security 6
✅ JWT Authentication (Access & Refresh Token)  
✅ Role-based Access Control (USER, ADMIN)
✅ Global Exception Handling
✅ PostgreSQL + JPA
✅ Swagger UI Integration
✅ BCrypt Password Encryption

━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🚨 **ERROR HANDLING**

Barcha xatolar standart JSON formatida qaytadi:

```json
{
  "timestamp": "2024-02-04 10:30:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Email yoki parol noto'g'ri",
  "path": "/api/auth/login"
}
```

Qo'llab-quvvatlanadigan xatolar:
• 400 - Validation xatosi
• 401 - Noto'g'ri parol / Token muddati tugagan
• 403 - Kirish taqiqlangan
• 404 - User topilmadi
• 409 - Email allaqachon ro'yxatdan o'tgan

━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📚 **API ENDPOINTS**

🔓 Public:
  → POST /api/auth/register - Ro'yxatdan o'tish
  → POST /api/auth/login - Tizimga kirish
  → GET /api/test/public - Test endpoint

🔒 Protected:
  → GET /api/test/user - USER endpoint
  → GET /api/test/admin - ADMIN endpoint (faqat admin)

📖 Swagger UI:
  → http://localhost:8080/swagger-ui.html

━━━━━━━━━━━━━━━━━━━━━━━━━━━━
🛠️ **TEXNOLOGIYALAR**

Backend:
  • Java 21
  • Spring Boot 3.2.1
  • Spring Security 6
  • Spring Data JPA

Security:
  • JWT (jjwt 0.11.5)
  • BCrypt Password Encoder

Database:
  • PostgreSQL

Documentation:
  • Swagger/OpenAPI 3

Build Tool:
  • Maven

Additional:
  • Lombok

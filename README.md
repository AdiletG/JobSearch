# JobSearch API

REST API платформа для поиска работы и найма сотрудников, вдохновленная HeadHunter и LinkedIn.  
Проект разработан на Java + Spring Boot и демонстрирует навыки backend-разработки, построения REST API, работы с базой данных, безопасности и многослойной архитектуры.

---

# 🚀 О проекте

JobSearch API — это backend-приложение, которое позволяет работодателям публиковать вакансии, а соискателям создавать резюме и откликаться на вакансии.

Проект реализован как pet-project с целью практики enterprise-подходов в backend-разработке.

## Основной функционал

### 👤 Соискатель (Applicant)
- регистрация и авторизация;
- создание резюме;
- редактирование и удаление резюме;
- просмотр всех вакансий;
- поиск вакансий по категории;
- отклик на вакансию;
- поиск работодателей;
- загрузка аватара.

### 🏢 Работодатель (Employer)
- регистрация и авторизация;
- создание вакансий;
- редактирование и удаление вакансий;
- просмотр резюме;
- поиск резюме по категории;
- просмотр откликов на вакансии;
- поиск соискателей;
- загрузка аватара.

---

# 🛠 Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate

## Database
- PostgreSQL

## Security
- JWT Authentication
- Role-based Authorization

## Additional
- Lombok
- Swagger / OpenAPI
- Maven
- DTO Mapping
- Validation API
- Multipart File Upload

---

# 🏗 Архитектура проекта

Проект построен по многослойной архитектуре:

```text
Controller
   ↓
Service
   ↓
Repository
   ↓
Database

Основные слои
Controller Layer

Обработка HTTP-запросов и возврат REST API ответов.

Service Layer

Бизнес-логика приложения.

Repository Layer

Работа с базой данных через Spring Data JPA.

Security Layer

JWT-аутентификация и авторизация пользователей.

🔐 Authentication & Authorization

В проекте реализована JWT-аутентификация.

После успешного входа пользователь получает JWT token, который используется для доступа к защищенным endpoint’ам.

Пример заголовка:

Authorization: Bearer <jwt_token>
📦 Основной функционал API
Authentication
Register
Login
User
Upload avatar
Get profile
Update profile
Vacancy
Create vacancy
Update vacancy
Delete vacancy
Get all vacancies
Search vacancies by category
Resume
Create resume
Update resume
Delete resume
Get all resumes
Search resumes by category
Response System
Apply to vacancy
Get applicants for vacancy
🗄 Database

Основные сущности проекта:

User
Resume
Vacancy
Category
Response
Employer
Applicant

Связи между сущностями реализованы через Hibernate/JPA.

▶️ Запуск проекта
1. Клонировать репозиторий
git clone https://github.com/AdiletG/JobSearch.git
2. Перейти в директорию проекта
cd JobSearch
3. Настроить application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/jobsearch_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
4. Запустить приложение
mvn spring-boot:run
📘 API Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html
📁 Пример структуры проекта
src
 ┣ main
 ┃ ┣ java
 ┃ ┃ ┣ controller
 ┃ ┃ ┣ service
 ┃ ┃ ┣ repository
 ┃ ┃ ┣ entity
 ┃ ┃ ┣ dto
 ┃ ┃ ┣ security
 ┃ ┃ ┗ config
 ┃ ┗ resources
 ┃   ┗ application.properties
🎯 Что демонстрирует проект

Данный проект демонстрирует навыки:

разработки REST API;
построения backend-архитектуры;
работы со Spring Boot ecosystem;
работы с PostgreSQL;
реализации JWT Security;
обработки файлов;
построения CRUD-систем;
работы с Hibernate/JPA;
использования DTO и маппинга;
построения role-based authorization;
проектирования многослойной архитектуры.
🔮 Возможные улучшения
Docker support
CI/CD integration
Unit & Integration tests
Redis caching
Email verification
Pagination & sorting
Global exception handling
Monitoring & logging
Microservice architecture

# 🚧 Project Status

Проект находится в активной разработке и продолжает расширяться новыми возможностями и инфраструктурными решениями.

## 📌 Planned Improvements

В ближайших обновлениях планируется добавить:

- Docker & Docker Compose
- Redis caching
- RabbitMQ message broker
- Unit & Integration tests
- CI/CD pipeline
- Pagination & sorting
- Centralized logging
- Monitoring & metrics
- Email notifications
- Improved exception handling

Проект активно развивается как backend pet-project с уклоном в enterprise-подходы и современные backend-технологии.

👨‍💻 Author

Adilet G.

Java Backend Developer

GitHub:
https://github.com/AdiletG

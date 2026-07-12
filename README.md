# TaskBridge Notification & Audit Service

## AI-Augmented Software Engineer Assessment

---

## Overview

TaskBridge is a B2B SaaS project collaboration platform that enables organizations to manage projects, track milestone progress, notify team members of important events, and maintain an immutable audit trail for compliance and traceability.

This repository contains a production-oriented implementation of the assessment solution using Java 21, Spring Boot, Gradle, and PostgreSQL. The solution demonstrates enterprise software engineering practices combined with AI-assisted development using GitHub Copilot.

The implementation follows a layered architecture and emphasizes maintainability, security, validation, clean code, and testability.

---

# Business Problem

Project management systems require more than CRUD operations.

Organizations need to:

- Manage projects and milestones
- Notify stakeholders when project milestones change
- Maintain an immutable audit history
- Enforce secure access to project information
- Produce reliable records for compliance and reporting

TaskBridge addresses these requirements through separate Project, Notification, and Audit components.

---

# Assessment Scope

This project implements:

- Project Service
- Notification Service
- Audit Service

The repository also documents the AI-assisted development process, architectural decisions, prompt engineering strategy, and review/remediation activities required by the assessment.

---

# Key Features

## Project Service

- Create projects
- Retrieve project information
- Update project milestone status
- Delete projects

## Notification Service

- Generate notifications for project events
- Retrieve unread notifications
- Mark notifications as read

## Audit Service

- Create immutable audit records
- Query audit history
- Filter audit events
- Support compliance and traceability

---

# Technology Stack

| Category | Technology |
|-----------|------------|
| Language | Java 21 LTS |
| Framework | Spring Boot 3.5.x |
| Build Tool | Gradle 8.x |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL 17 |
| Test Database | H2 |
| Validation | Jakarta Bean Validation |
| Security | Spring Security |
| Documentation | OpenAPI (SpringDoc) |
| Testing | JUnit 5, Mockito |
| IDE | Visual Studio Code |
| AI Assistant | GitHub Copilot |

---

# Architecture

The application follows a layered architecture.

```
Client
    │
REST Controller
    │
Service Layer
    │
Repository Layer
    │
PostgreSQL
```

Responsibilities are clearly separated.

- Controllers expose REST APIs.
- Services contain business logic.
- Repositories handle persistence.
- Entities represent database objects.
- DTOs define API contracts.

---

# Project Structure

```
taskbridge-api
│
├── .github
│   └── copilot-instructions.md
│
├── docs
│   ├── SPEC.md
│   ├── REVIEW.md
│   ├── IMPACT_ANALYSIS.md
│   ├── PROMPTS.md
│   ├── PR_DESCRIPTION.md
│   ├── TOOL_STRATEGY.md
│   └── ARCHITECTURE.md
│
├── src
│
│   ├── main
│   │
│   │   ├── java
│   │   │
│   │   └── com.taskbridge
│   │       ├── project
│   │       ├── notification
│   │       ├── audit
│   │       ├── common
│   │       ├── config
│   │       ├── exception
│   │       ├── security
│   │       └── shared
│   │
│   └── test
│
├── build.gradle
└── README.md
```

---

# Prerequisites

Before running the application ensure the following software is installed.

- Java 21
- Gradle 8.x (or use the Gradle Wrapper)
- PostgreSQL 17
- Git
- Visual Studio Code
- GitHub Copilot

---

# Database Configuration

Create a PostgreSQL database.

Example:

```
Database Name : taskbridge
Username      : postgres
Port          : 5432
```

Application-specific connection properties are configured in:

```
src/main/resources/application.properties
```

---

# Build

Using Gradle Wrapper

Windows

```
gradlew.bat clean build
```

Linux/macOS

```
./gradlew clean build
```

---

# Run the Application

```
gradlew.bat bootRun
```

or

```
./gradlew bootRun
```

The application starts on:

```
http://localhost:8080
```

---

# Running Tests

Execute all tests.

```
gradlew.bat test
```

Generate the test report.

```
build/reports/tests/test/index.html
```

---

# API Documentation

OpenAPI documentation is available after the application starts.

```
http://localhost:8080/swagger-ui.html
```

or

```
http://localhost:8080/swagger-ui/index.html
```

(depending on the configured SpringDoc version)

---

# Design Principles

This implementation follows the following principles.

- SOLID
- Separation of Concerns
- Layered Architecture
- Constructor Injection
- DTO-based APIs
- Repository Pattern
- Centralized Exception Handling
- Bean Validation
- Immutable Audit Records
- Secure Coding Practices

---

# AI-Assisted Development

GitHub Copilot was used as an AI-assisted software engineering tool throughout the assessment.

AI assistance was used for:

- Project scaffolding
- Boilerplate generation
- Code suggestions
- Unit test generation
- Documentation assistance

Every AI-generated artifact was manually reviewed, validated, and improved before inclusion in the final implementation.

---

# Quality Goals

The implementation aims to achieve:

- Production-quality code
- Enterprise architecture
- Secure coding practices
- High readability
- Comprehensive testing
- Maintainable design
- Clean REST APIs

---

# Future Enhancements

Potential future improvements include:

- Event-driven notifications
- Email integration
- WebSocket notifications
- Role-based authorization
- Multi-factor authentication
- Distributed caching
- Observability with Micrometer
- Containerized deployment
- CI/CD pipeline integration

---

# Repository Deliverables

This repository includes the following assessment artifacts.

- README.md
- .github/copilot-instructions.md
- SPEC.md
- REVIEW.md
- IMPACT_ANALYSIS.md
- PROMPTS.md
- PR_DESCRIPTION.md
- TOOL_STRATEGY.md
- ARCHITECTURE.md
- Project Service
- Notification Service
- Audit Service
- Unit Tests

---

# License

This repository has been developed exclusively for the AI-Augmented Software Engineer Assessment and is intended for educational and evaluation purposes.
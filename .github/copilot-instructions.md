# GitHub Copilot Instructions

## Project Overview

This repository contains the implementation of the TaskBridge Notification & Audit Service for a B2B SaaS project collaboration platform.

The solution is implemented using Java 21, Spring Boot 3.5.x and Gradle following enterprise software engineering practices.

GitHub Copilot should be treated as an AI-assisted development tool. Generated code must always be reviewed, validated, tested and refactored before acceptance.

---

# Technology Stack

- Java 21
- Spring Boot 3.5.x
- Gradle 8.x
- Spring Data JPA
- Hibernate ORM
- PostgreSQL
- H2 Database (Testing)
- Spring Security
- Jakarta Validation
- Lombok
- JUnit 5
- Mockito

---

# Architecture

Follow a layered architecture.

Controller
↓

Service
↓

Repository
↓

Database

Controllers must never directly access repositories.

Business logic belongs only inside services.

Repositories are responsible only for persistence.

---

# Package Structure

Use the following package structure.

com.taskbridge

- common
- config
- exception
- security
- shared
- project
- notification
- audit

Each business module must contain:

- controller
- service
- repository
- entity
- dto
- mapper
- validator

Do not introduce unnecessary packages.

---

# Java Coding Standards

Use Java 21 language features where appropriate.

Prefer:

- Records for immutable DTOs
- Enum for fixed values
- Optional where appropriate
- Constructor injection
- final variables whenever possible

Avoid:

- Field injection
- Wildcard imports
- Static mutable state
- Magic numbers
- Long methods
- Deep nesting

Target method length:

Less than 30 lines whenever practical.

---

# Spring Boot Standards

Use:

@RestController

@RequestMapping

@Service

@Repository

@Component

@Configuration

@Entity

Never use XML configuration.

Prefer constructor injection.

Use ResponseEntity for REST responses.

---

# REST API Standards

Use nouns for resource names.

Good

/projects

/notifications

/audit

Avoid verbs in endpoint names.

Use proper HTTP methods.

GET

POST

PUT

PATCH

DELETE

Return appropriate HTTP status codes.

200

201

204

400

401

403

404

409

500

---

# DTO Rules

Never expose JPA entities through REST APIs.

Always create:

Request DTO

Response DTO

Validate all request DTOs.

---

# Entity Rules

Use JPA annotations.

Each entity must have:

Primary Key

Created Timestamp

Updated Timestamp where applicable

Meaningful relationships

Do not place business logic inside entities.

---

# Repository Rules

Repositories should extend Spring Data JPA interfaces.

Avoid custom SQL unless absolutely necessary.

Prefer derived query methods.

---

# Service Layer Rules

Business rules belong only inside services.

Services should:

Validate business rules

Coordinate repositories

Handle transactions

Trigger notifications

Create audit records

Services must not return entities directly.

---

# Validation

Use Jakarta Validation.

Examples include:

@NotNull

@NotBlank

@Size

@Email

@Positive

Business validation belongs inside services.

---

# Exception Handling

Use a centralized @ControllerAdvice.

Create specific exceptions such as:

ResourceNotFoundException

BusinessException

ConflictException

UnauthorizedException

Avoid generic Exception handling except for logging and rethrowing.

---

# Logging

Use SLF4J.

Log:

Application startup

Business events

Security events

Failures

Do not log:

Passwords

JWT tokens

Secrets

Personally sensitive information

Use parameterized logging.

---

# Security

Use Spring Security.

Prefer JWT-based authentication.

Validate authorization before business logic.

Never trust client-supplied organization identifiers.

Always enforce tenant isolation.

---

# Database

Use Spring Data JPA.

Avoid raw JDBC.

Avoid native SQL unless necessary.

Prefer entity relationships over manual joins.

---

# Transactions

Use @Transactional only in service layer.

Keep transactions small.

Avoid unnecessary nested transactions.

---

# Testing

Use:

JUnit 5

Mockito

Spring Boot Test

Create tests for:

Controllers

Services

Repositories

Validation

Security

Edge cases

Target high code coverage with meaningful assertions.

---

# GitHub Copilot Usage

GitHub Copilot should be used to:

Generate boilerplate

Generate unit tests

Suggest documentation

Generate DTOs

Generate repositories

Generate REST controllers

Do not accept generated code without review.

Always verify:

Correctness

Security

Performance

Maintainability

Readability

---

# Code Review Expectations

Review every AI-generated change for:

SOLID principles

Clean Code

Security

Validation

Exception handling

Performance

Thread safety

Naming conventions

Package organization

Duplication

Reject code that:

Duplicates logic

Exposes entities

Contains hardcoded secrets

Contains dead code

Ignores validation

Violates layered architecture

---

# Documentation

Every public class should include meaningful JavaDoc where it improves understanding.

Complex business rules should include concise comments explaining intent rather than implementation.

---

# General Principle

Prefer maintainable, readable and secure code over clever code.

Every generated class should be production-ready and suitable for enterprise software development.
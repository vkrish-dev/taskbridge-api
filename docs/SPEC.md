# Technical Specification

## TaskBridge Notification & Audit Service

---

## Document Information

| Field | Value |
|--------|-------|
| Document | Technical Specification |
| Version | 1.0 |
| Status | Draft |
| Project | TaskBridge Notification & Audit Service |
| Language | Java 21 |
| Framework | Spring Boot 3.5.x |
| Build Tool | Gradle |
| Database | PostgreSQL 17 |
| Test Database | H2 |

---

# 1. Purpose

This document defines the functional and technical specification for the TaskBridge Notification & Audit Service.

It serves as the reference for architecture, implementation, testing, and AI-assisted development activities performed during this assessment.

---

# 2. Project Overview

TaskBridge is a project collaboration platform that allows organizations to manage projects, update milestone status, notify users about project events, and maintain immutable audit records.

The solution consists of three logical modules:

- Project Service
- Notification Service
- Audit Service

---

# 3. Scope

## In Scope

### Project Service

- Create Project
- Retrieve Project
- Retrieve All Projects
- Update Milestone Status
- Delete Project

### Notification Service

- Create Notifications
- Retrieve Unread Notifications
- Mark Notification as Read

### Audit Service

- Create Audit Record
- Retrieve Audit History
- Filter Audit History

### Cross-Cutting Concerns

- Validation
- Logging
- Security
- Exception Handling
- ORM Persistence
- Unit Testing

---

## Out of Scope

- Email notifications
- SMS notifications
- Push notifications
- User Management
- OAuth Provider
- Workflow Engine
- Reporting
- Analytics
- Distributed Messaging

---

# 4. Technology Stack

| Component | Technology |
|------------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3.5.x |
| ORM | Spring Data JPA |
| Database | PostgreSQL 17 |
| Test Database | H2 |
| Validation | Jakarta Bean Validation |
| Security | Spring Security |
| Build | Gradle |
| Testing | JUnit 5, Mockito |

---

# 5. Architecture

The application follows a layered architecture.

```
REST Controller
        │
        ▼
Business Service
        │
        ▼
Repository
        │
        ▼
Database
```

## Layer Responsibilities

### Controller

- Expose REST endpoints
- Validate requests
- Return HTTP responses

### Service

- Implement business rules
- Coordinate persistence
- Trigger notifications
- Record audit events

### Repository

- Persist data
- Retrieve data

---

# 6. Functional Requirements

## Project Service

### FR-001

Create a project.

### FR-002

Retrieve a project by identifier.

### FR-003

Retrieve all projects.

### FR-004

Update milestone status.

### FR-005

Delete a project.

---

## Notification Service

### FR-006

Generate a notification when a milestone status changes.

### FR-007

Retrieve unread notifications.

### FR-008

Mark notification as read.

---

## Audit Service

### FR-009

Create immutable audit records.

### FR-010

Retrieve audit history.

### FR-011

Filter audit history.

---

## Cross-Cutting

### FR-012

Validate all incoming requests.

### FR-013

Use ORM persistence.

### FR-014

Return standardized error responses.

### FR-015

Log significant business events.

---

# 7. Domain Model

## Project

| Field | Type |
|--------|------|
| id | Long |
| name | String |
| description | String |
| teamId | Long |
| milestoneName | String |
| milestoneStatus | Enum |
| createdAt | Timestamp |
| updatedAt | Timestamp |

---

## Notification

| Field | Type |
|--------|------|
| id | Long |
| userId | Long |
| projectId | Long |
| message | String |
| read | Boolean |
| createdAt | Timestamp |

---

## AuditRecord

| Field | Type |
|--------|------|
| id | Long |
| projectId | Long |
| eventType | String |
| previousValue | String |
| newValue | String |
| performedBy | String |
| timestamp | Timestamp |

---

# 8. REST API Summary

## Project

| Method | Endpoint |
|----------|----------|
| POST | /projects |
| GET | /projects/{id} |
| GET | /projects |
| PUT | /projects/{id}/status |
| DELETE | /projects/{id} |

---

## Notification

| Method | Endpoint |
|----------|----------|
| GET | /notifications/{userId} |
| PATCH | /notifications/{id}/read |

---

## Audit

| Method | Endpoint |
|----------|----------|
| POST | /audit |
| GET | /audit/{projectId} |

---

# 9. Validation

Request validation shall use Jakarta Bean Validation.

Examples include:

- @NotNull
- @NotBlank
- @Size
- @Positive

Business validation shall be implemented in the service layer.

---

# 10. Exception Handling

The application shall use centralized exception handling with @ControllerAdvice.

Exceptions shall be mapped to standard HTTP status codes.

---

# 11. Logging

The application shall use structured logging.

Sensitive information such as passwords and tokens shall never be logged.

---

# 12. Testing

The implementation shall include:

- Unit Tests
- Repository Tests
- Controller Tests
- Validation Tests

---

# 13. Acceptance Criteria

The implementation is considered complete when:

- All functional requirements are implemented.
- REST APIs are operational.
- Data is persisted using JPA.
- Validation is enforced.
- Unit tests pass.
- Notification and Audit functionality operate correctly.

---

# 14. Traceability

| Requirement | Module |
|-------------|--------|
| FR-001 | Project Service |
| FR-002 | Project Service |
| FR-003 | Project Service |
| FR-004 | Project Service |
| FR-005 | Project Service |
| FR-006 | Notification Service |
| FR-007 | Notification Service |
| FR-008 | Notification Service |
| FR-009 | Audit Service |
| FR-010 | Audit Service |
| FR-011 | Audit Service |
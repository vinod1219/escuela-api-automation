# Escuela API Tests

This project contains automated API tests for the Escuela API. The tests are written in Java using the TestNG framework and Rest-Assured for API interactions. The project is structured to ensure reusability, maintainability, and scalability.

---

## Project Structure

### `src/main/java`
- **`com.automation.escuela.base`**: Contains base classes for API interactions.
  - `BaseService`: Provides common methods for making API requests (GET, POST) and setting authentication tokens.
  - `AuthService`: Extends `BaseService` and includes methods for login, profile retrieval, and token refresh.

- **`com.automation.escuela.models`**: Contains POJOs for request and response payloads.
  - `LoginRequest`: Represents the login request payload.
  - `ProfileResponse`: Represents the profile response payload.

### `src/test/java`
- **`com.automation.escuela.tests`**: Contains test classes.
  - `BaseTest`: Handles setup tasks like logging in and retrieving tokens.
  - `LoginAPITests`: Contains test cases for login, profile, and token refresh functionalities.

- **`com.automation.escuela.listeners`**: Contains TestNG listeners.
  - `TestListener`: Logs test execution details (start, success, failure, etc.) using Log4j.

### `src/test/resources`
- **`data/jsonfiles`**: Contains test data in JSON format.
  - `Login.json`: Stores login credentials.
  - `Profile.json`: Stores expected profile response payload.

- **`log4j2.xml`**: Configuration file for Log4j2, defining console and file appenders for logging.

---

## Dependencies

The project uses the following dependencies:
- **Rest-Assured**: For API testing.
- **TestNG**: For test execution and reporting.
- **Jackson**: For JSON serialization and deserialization.
- **Log4j2**: For logging test execution details.

Refer to the `pom.xml` file for the complete list of dependencies.

---

## How to Run the Tests

1. Clone the repository and navigate to the project director
---

## Logging

The project uses Log4j2 for logging. Logs are configured in the `log4j2.xml` file and include:
- **Console Logging**: Outputs logs to the console.
- **File Logging**: Saves logs to `logs/test.log`.

### Log Levels
- **INFO**: Logs test start and success events.
- **ERROR**: Logs test failures.
- **WARN**: Logs skipped tests or partial failures.

---

## TestNG Listeners

The `TestListener` class implements the `ITestListener` interface to log test execution details. It integrates with Log4j2 to provide detailed logs for:
- Test start
- Test success
- Test failure
- Test skipped

---

## Test Data Management

Test data is stored in JSON files under the `src/test/resources/data/jsonfiles` directory. These files are dynamically read during test execution to avoid hardcoding values.

### Example: Reading Login Credentials
The `Login.json` file contains the following structure:

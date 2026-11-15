# OrangeHRM – Selenium Java Automation Framework

End-to-end UI automation framework for the OrangeHRM Open Source demo application, built with Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM).

## Tech stack

- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Page Object Model (POM)
- GitHub Actions

## Application under test

https://opensource-demo.orangehrmlive.com/

The public demo environment can change, reset data, or become temporarily unavailable. Tests depend on the demo site's current UI and shared test data.

## Test coverage

| Module | Scenarios |
|---|---|
| Authentication | Valid admin login, invalid credentials, logout |
| PIM | Open PIM module, add an employee |
| Admin | Open Admin module, search for Admin user |
| Diagnostics | Screenshot capture on test failure |
| CI | Maven/TestNG suite runs through GitHub Actions |

## Project structure

```text
orangehrm-selenium-java/
├── .github/workflows/maven-tests.yml
├── src/test/
│   ├── java/
│   │   ├── base/
│   │   │   ├── BaseTest.java
│   │   │   └── DriverFactory.java
│   │   ├── listeners/TestListener.java
│   │   ├── pages/
│   │   │   ├── LoginPage.java
│   │   │   ├── DashboardPage.java
│   │   │   ├── PimPage.java
│   │   │   └── AdminPage.java
│   │   ├── tests/
│   │   │   ├── LoginTests.java
│   │   │   ├── PimTests.java
│   │   │   └── AdminTests.java
│   │   └── utils/
│   │       ├── ConfigReader.java
│   │       ├── ScreenshotUtils.java
│   │       └── TestData.java
│   └── resources/config.properties
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites

Install:
- JDK 17 or later
- Maven 3.8+
- Google Chrome
- Git

Verify:

```bash
java -version
mvn -version
```

Selenium Manager, included with Selenium 4, resolves the compatible ChromeDriver in supported environments.

## Run the project

Clone your GitHub repository and open it in IntelliJ IDEA or VS Code.

Run all tests:

```bash
mvn clean test
```

Run headless:

```bash
mvn clean test -Dheadless=true
```

Override the application URL:

```bash
mvn clean test -DbaseUrl=https://opensource-demo.orangehrmlive.com/
```

## Demo credentials

The OrangeHRM public demo commonly publishes these credentials:

- Username: `Admin`
- Password: `admin123`

Demo credentials and site behavior are controlled by the application provider and may change. Do not use these credentials on any other system.

## Framework features

- **Page Object Model:** Page locators and interactions are separated from test cases.
- **DriverFactory:** Centralized browser creation and teardown.
- **Explicit waits:** Waits for important UI elements instead of relying on fixed sleeps.
- **Reusable test data:** Common credentials and values are centralized.
- **TestNG:** Test organization and smoke/regression groups.
- **Failure screenshots:** Listener captures screenshots when a test fails.
- **Maven:** Dependency management and test execution.
- **GitHub Actions:** Runs the suite on pushes and pull requests.

## Reports and screenshots

After execution:
- TestNG/Surefire reports: `target/surefire-reports/`
- Failure screenshots: `target/screenshots/`

## Suggested improvements

- Add data-driven tests with TestNG `@DataProvider`.
- Add Extent Reports or Allure reporting.
- Add Firefox and Edge browser support.
- Add retry analyzer and parallel execution.
- Add employee search, edit, and delete workflows.
- Add environment profiles for QA and staging.
- Add API tests for test-data setup and cleanup.

## Portfolio summary

This project demonstrates Java-based UI automation, Selenium WebDriver, TestNG, Maven, reusable POM architecture, employee-management workflows, failure screenshots, and CI execution with GitHub Actions.

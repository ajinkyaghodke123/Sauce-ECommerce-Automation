# SauceDemo E-Commerce Order Management Automation

End-to-end order-management automation for the [SauceDemo](https://www.saucedemo.com/) store, built with **Cucumber BDD**, **Selenium WebDriver** and the **Page Object Model**.

## Scenarios covered

- Log in with valid credentials
- Add a product to the cart (single product and data-driven outline)
- Checkout with customer details
- Verify the order confirmation message

## Tech stack

Java 11 · Selenium WebDriver 4 · Cucumber 7 · JUnit 4 · WebDriverManager · Maven

## Project structure

```
src/test/java
├── pageobjects/   Page Object classes (login, inventory, cart, checkout)
├── stepdefs/      Cucumber step definitions and Hooks (driver setup/teardown)
└── runners/       TestRunner (Cucumber JUnit runner)
src/test/resources/features/order_management.feature
.github/workflows/ci.yml   Headless test run on every push and pull request
```

## Prerequisites

- JDK 11 or newer
- Maven 3.8+
- Google Chrome

## Run the tests

```bash
mvn clean test                    # opens Chrome
mvn clean test -Dheadless=true    # headless, used in CI
```

The HTML report is written to `target/cucumber-report.html`.

## Notes

The credentials used (`standard_user` / `secret_sauce`) are the public demo logins published by SauceDemo, not real secrets.

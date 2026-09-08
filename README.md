# OpenCart Test Automation Framework

A Selenium WebDriver + TestNG automation framework for testing the [OpenCart](https://www.opencart.com/) demo e-commerce application. Built using the **Page Object Model (POM)** design pattern with support for cross-browser testing, data-driven testing, and remote execution on Selenium Grid.

## 🧰 Tech Stack

| Tool / Library | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver 4.41.0 | Browser automation |
| TestNG 7.12.0 | Test execution & assertions |
| Maven | Build & dependency management |
| Apache Commons Lang3 | Random string/number generation for test data |
| Selenium Grid / RemoteWebDriver | Cross-browser & remote execution |

## 📁 Project Structure

```
OpenCart/
├── src/test/java/
│   ├── PageObjects/
│   │   ├── BasePage.java              # Base class initializing PageFactory elements
│   │   ├── HomePage.java              # Home page elements & actions
│   │   ├── LoginPage.java             # Login page elements & actions
│   │   ├── MyAccountPage.java         # My Account page elements & actions
│   │   └── Registration_Page.java     # Registration page elements & actions
│   └── TestCase/
│       ├── BaseCase.java              # Driver setup/teardown, config loading, utility methods
│       ├── DP.java                    # TestNG @DataProvider for data-driven tests
│       ├── TC001_AcctRegistration.java # Account registration test
│       └── TC002_Login_DDT.java       # Data-driven login test
├── src/test/resources/
│   └── source.txt                     # Config: env (local/remote), app URL, etc.
├── testng.xml                         # Default single-browser test suite
├── Login.xml                          # Suite targeting the login test
├── CrossBrowser.xml                   # Parallel suite across Chrome/Edge/Firefox (local)
├── SeleniumGrid.xml                   # Parallel suite for execution via Selenium Grid
├── docker.xml                         # Parallel suite for execution in Docker/Linux containers
├── run.bat                            # Windows batch script to trigger a Maven test run
└── pom.xml                            # Maven project configuration & dependencies
```

## 🎯 Framework Design

- **Page Object Model (POM):** Each web page is represented as a class in `PageObjects`, encapsulating locators and actions. `BasePage` initializes elements via `PageFactory`.
- **Base Test Class:** `BaseCase` centralizes WebDriver setup/teardown (`@BeforeClass` / `@AfterClass`), reads runtime configuration from `source.txt`, and provides helper methods for generating random test data (strings, numbers, alphanumeric).
- **Data-Driven Testing:** `DP.java` supplies login credentials via a TestNG `@DataProvider`, used by `TC002_Login_DDT`.
- **Configurable Execution Environment:** The `env` property in `source.txt` toggles between:
  - `local` — runs tests directly against a local `ChromeDriver` / `FirefoxDriver` / `EdgeDriver`
  - `remote` — runs tests via `RemoteWebDriver` against a Selenium Grid hub
- **Cross-Browser & Parallel Execution:** Multiple TestNG XML suites (`CrossBrowser.xml`, `SeleniumGrid.xml`, `docker.xml`) run the same tests in parallel across Chrome, Edge, and Firefox on Windows or Linux.

## ✅ Prerequisites

- Java JDK 8+
- Apache Maven
- Google Chrome / Mozilla Firefox / Microsoft Edge (for local runs)
- A running Selenium Grid hub (only required for `remote` execution — see `SeleniumGrid.xml` / `docker.xml`)

## ⚙️ Configuration

Before running the tests, update `src/test/resources/source.txt` with:

```properties
env=local            # or "remote" to run against a Selenium Grid hub
appurl=<opencart-app-url>
```

## 🚀 Running the Tests

### Using Maven directly
```bash
mvn clean test
```
This runs the default suite defined in `pom.xml` (`testng.xml`).

### Using a specific TestNG suite
```bash
mvn clean test -DsuiteXmlFile=CrossBrowser.xml
```
Replace `CrossBrowser.xml` with `Login.xml`, `SeleniumGrid.xml`, or `docker.xml` as needed.

### Using the provided batch script (Windows)
```bash
run.bat
```
> Note: `run.bat` currently contains a hardcoded local workspace path — update it to match your environment before running.

## 📊 Test Reports

TestNG generates HTML/XML reports in the `test-output/` directory after each run. Open `test-output/index.html` in a browser to view results.

## 🧪 Test Cases

| Test ID | Description | Type |
|---|---|---|
| TC001 | New user account registration on OpenCart | Functional |
| TC002 | Login with multiple valid/invalid credential sets | Data-driven |

## 👤 Author

**Vaishnavi Venkatesh** ([@vaishnavi1974](https://github.com/vaishnavi1974))

# 🚀 Playwright Page Object Model Framework (Java)

A scalable, maintainable test automation framework built with **Playwright Java**, leveraging the **Page Object Model (POM)** design pattern and **TestNG**.

---

## 🧰 Tech Stack

- 🎭 **Playwright Java** – Browser automation for Chromium, Firefox, WebKit  
- 📦 **TestNG** – Testing framework with support for parallel execution, data providers, and assertions  
- 📊 **Extent Reports** – Rich and interactive HTML test reports  
- 📝 **Apache POI** – Data-driven testing via Excel files  
- 🪵 **Log4j** – Comprehensive logging  
- ⚙️ **Maven** – Dependency and build management  

---

## 📁 Project Structure

```

PlaywrightPageObjectModelFrameworkJava/
├── README.md<br />
├── pom.xml<br />
├── src<br />
│   ├── main<br />
│   │   └── java<br />
│   │       └── org<br />
│   │           └── sharfulumair<br />
│   │               ├── base<br />
│   │               │   ├── BasePage.java<br />
│   │               │   └── BaseTest.java<br />
│   │               ├── pages<br />
│   │               │   ├── HomePage.java<br />
│   │               │   ├── LoginPage.java<br />
│   │               │   └── … (other page objects)<br />
│   │               ├── utilities<br />
│   │               │   ├── ExcelReader.java<br />
│   │               │   ├── Log.java<br />
│   │               │   ├── TestUtil.java<br />
│   │               │   └── Constants.java<br />
│   └── test<br />
│       ├── java<br />
│       │   └── testcases<br />
│       │       ├── LoginTest.java<br />
│       │       └── … (other TestNG test classes)<br />
│       └── resources<br />
│           ├── testdata<br />
│           │   └── testdata.xlsx<br />
│           └── logs<br />
│               └── framework.log<br />
└── test-output<br />
└── ExtentReport.html<br />

````

---

## ✅ Features

- Clean **Page Object Model** design for readability and maintainability  
- **Data-driven** tests using Excel via `@DataProvider`  
- **Parallel execution** enabled through TestNG  
- **Beautiful test reports** with Extent Reports  
- Detailed **logging** via Log4j  
- Configured for easy integration into **CI pipelines**  

---

## 🛠️ Getting Started

### Prerequisites

- Java 11 or newer  
- Maven 3.6+  
- Browsers: Chrome, Firefox, WebKit  
- IDE: IntelliJ IDEA, Eclipse, or similar  

### Installation & Build

```bash
git clone https://github.com/sharful-umair/PlaywrightPageObjectModelFrameworkJava.git
cd PlaywrightPageObjectModelFrameworkJava
mvn clean install
````

### 🧪 Running Tests

Execute the full TestNG suite:

```bash
mvn test
```

Run specific tests:

```bash
mvn -Dtest=LoginTest test
```

---

## 📈 Reports & Logs

* HTML report is generated at `test-output/ExtentReport.html`
* Log file: `src/test/resources/logs/framework.log`
* Adjust report formats, themes, and other settings in your TestNG or utility config classes

---

## 📄 Test Data

* Excel file: `src/test/resources/testdata/testdata.xlsx`
* Read using Apache POI in `ExcelReader.java`
* Linked to tests via TestNG `@DataProvider` methods

---

## 🔄 CI/CD Integration

Easily add to your CI pipeline (Jenkins, GitHub Actions, Azure, GitLab):

```yaml
# Example snippet for GitHub Actions (.github/workflows/ci.yml)
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '11'
      - name: Build & Test
        run: mvn clean test
      - name: Archive Report
        run: cp test-output/ExtentReport.html ${{ github.workspace }}
```

---

## 🤝 Contributing

Contributions welcome!

1. Fork the repo
2. Create a feature branch (`git checkout -b feature-name`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to your branch (`git push origin feature-name`)
5. Open a pull request

For substantial changes, please open an issue to discuss your proposal beforehand.

---

## 👨‍💻 Author

**Sharful Umair**
🔗 [GitHub](https://github.com/sharful-umair)
🔗 [LinkedIn](https://linkedin.com/in/sharfulumair)

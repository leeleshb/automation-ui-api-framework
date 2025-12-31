# automation-ui-api-framework
Hybrid Selenium + Rest Assured Automation Framework
📌 Overview
This project is a hybrid automation framework designed to test Web UI and REST APIs in a single Maven-based project.
It uses Selenium WebDriver with TestNG for UI automation and Rest Assured for API automation, following the Page Object Model (POM) and modular design principles.

🛠 Tech Stack
•	Java
•	Maven
•	Selenium WebDriver
•	TestNG
•	Rest Assured
•	Web Driver Manager 

⚙️ Setup Instructions
Prerequisites
Ensure the following are installed on your system:
•	Java 11 or higher
•	Maven 3.8+
•	Chrome / Edge / Firefox browser

Verify installations:
java -version
mvn -version
________________________________________
Clone the Repository
git clone <repository-url>
cd project-root
________________________________________
▶️ Execution Command
To execute all UI and API tests, run:
mvn clean test
This command will:
•	Clean previous build files
•	Compile the project
•	Execute all TestNG test cases defined in testng.xml
•	Generate test reports under target/surefire-reports
________________________________________
🧠 Framework Design Explanation
This framework follows the Page Object Model (POM) design pattern to improve test maintainability and readability.
Each web page in the application has a corresponding Page class that contains element locators and business actions, while the Test classes focus only on validations and test flow. This separation ensures minimal impact on tests when UI changes occur.
For API automation, the framework uses a client-layer approach, where each API is represented by a dedicated client class responsible for making HTTP requests. Response validations and test logic are handled in TestNG test classes. Common configurations such as base URI, headers, and authentication handling are centralized to avoid duplication and hardcoding.
The framework is configuration-driven, meaning environment details, browser selection, URLs, and test data are externalized into properties files. This allows easy switching between environments and browsers without code changes. The entire framework is built using Maven, enabling seamless execution via a single command (mvn clean test) and easy CI/CD integration.

📌 Assumptions
•	The application under test is stable and accessible during test execution.
•	Test data provided in testdata.properties is valid and consistent.
•	Browsers are installed locally, and WebDriver binaries are managed automatically using WebDriverManager.
•	API endpoints are publicly accessible and do not require additional network configurations such as VPN.
•	Tests are executed in a non-parallel mode by default.
________________________________________
📊 Test Reports
After execution, reports are generated at:
target/surefire-reports/
________________________________________
🔧 Future Enhancements
•	Parallel execution support
•	Cross-browser execution via Maven profiles
•	CI/CD integration (Jenkins / GitHub Actions)
•	Reporting using Allure or Extent Reports
________________________________________
✅ Conclusion
This framework provides a scalable and maintainable solution for end-to-end automation testing, covering both UI and API layers within a single project. Its modular architecture ensures easy enhancements and long-term sustainability.
________________________________________

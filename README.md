# qa-tests
QA Automated Tests
# Test-automation- Quick start
Can clone the project using the command git clone https://github.com/IssuerDirect/qa-tests.git
Java quick start project for test automation, covering performance, UI acceptance, API acceptance testing and security testing. 
## Concepts Included
•	Dependency injection
•	Page Object pattern
•	Common web page interaction methods
•	Mavenised performance tests
•	Externalized test configuration
•	Commonly used test utility classes
•	Simple security tests
## Tools
•	Maven
•	TestNG
•	Selenium Webdriver
•	Extent Reporting/ TestNG reports
## Requirements
In order to utilize this project you need to have the following installed locally:
•	Maven 3
•	Chrome and Chromedriver (UI tests use Chrome by default, can be changed in config)
•	Java 1.8
## Usage
The project is broken into separate modules for API, UI, Performance and Security testing. Each of these modules can be utilised independently of the others using maven profiles.
To run all modules, navigate to test-automation-quickstart directory and run:
mvn clean install
To run UI acceptance tests only, navigate to test-automation-quickstart directory and run:
mvn clean install -Pui-acceptance-tests
To run API acceptance tests only, navigate to test-automation-quickstart directory and run:
mvn clean install -Papi-acceptance-tests
To run performance tests only, navigate to test-automation-quickstart directory and run:
mvn clean install -Pperformance-tests
To run security tests only, navigate to test-automation-quickstart directory and run:
mvn clean install -Psecurity-acceptance-tests
## Reporting
Reports for each module are written into their respective /target directories after a successful run.
In the case of test failures, a screen-shot of the UI at the point of failure is embedded into the report.





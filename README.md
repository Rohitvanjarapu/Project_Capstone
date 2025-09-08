   Project Capstone – SwagLabs Automation Testing                                                       
-> Overview

This project automates end-to-end testing of the SauceDemo (SwagLabs) application.
The goal is to build a robust Cucumber BDD automation framework using Selenium and integrate it with Jenkins for CI/CD.

-> Objectives

<>Automate functional test cases such as Login, Cart, Sorting, and Checkout.
<>Follow best practices with Page Object Model (POM).
<>Support BDD with Cucumber and Gherkin feature files.
<>Enable cross-browser execution (Chrome, Firefox).
<>Integrate Jenkins pipeline for CI/CD.
<>Generate detailed test reports with Extent or Allure.

-> Tech Stack

Language: Java
Automation Tool: Selenium WebDriver
Framework: Cucumber (BDD) with JUnit
Build Tool: Maven
Reports: Extent Reports or Allure Reports
CI/CD: Jenkins
Version Control: GitHub

-> Project Structure

Pages: Page Object Model classes
Step Definitions: Cucumber step definition classes
Runners: Cucumber test runners
Features: Gherkin feature files
Utilities: Common reusable methods
Reports: Test execution reports

-> Test Scenarios Automated

Login (valid and invalid users, locked-out users)
Cart functionality (add and remove single or multiple items)
Product sorting (A–Z, Z–A, Price low–high, Price high–low)
WebDriver setup validation
Checkout flow (if implemented)

-> How to Run

Clone the repository from GitHub.
Build the project with Maven.
Run all tests with Maven commands or directly from the runner classes.
To run specific features, provide the feature file path as an option.

-> Run via Jenkins

Configure a Pipeline job in Jenkins.
Point it to this GitHub repository and the Jenkinsfile.
Trigger the build to execute tests and generate reports.

-> Reports

JUnit XML reports are generated under the test reports directory.
Extent or Allure Reports provide detailed graphical test execution results.

-> Contribution

Fork the repository
Create a feature branch
Commit changes
Submit a pull request

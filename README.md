# Automated Testing for a Test Web Application [skleptest.pl](https://skleptest.pl/)

## Framework

- Maven project
- Java programming language
- Selenide libraries for interacting with the application's DOM elements
- PageObject pattern for organizing classes and methods
- Cucumber framework based on BDD methodology
- JUnit framework mainly used for reporting and monitoring tests on Jenkins

Additionally:
The test environment configuration launches an additional Selenoid container on Jenkins (configuration in the selenoid.yml and browsers.json files). It acts as a hub managing access to WebDriver for browsers (Chrome, Opera, Firefox).

## Configuration

- The config.properties file contains default settings for the test execution parameters.
-  can change the invocation parameters by modifying the entries in the above file or by running tests or a specific test from the console.

```sh
mvn -Durl=[https://adres] -DremoteUrl=[http://hub selenoid] -Dbrowser=[nazwa] -DbrowserVersion=[numer wersji] clean test
```

## Debugging

- The default configuration runs tests on the address <https://skleptest.pl/>  using the Chrome browser and the local machine's WebDriver where the tests are executed.


## Rules and Plugins

- The tests are independent of each other.
- Plugins for Cucumber.

| Plugins                     |
| -------------------------- |
| Cucumber +                 |
| Cucumber for Java          |
| Cucumber Scenarios Indexer |
| Gherkin                    |

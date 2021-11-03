# Chiper - TestApi

its a simple test of automation API

## Pre-Requirements

You need to install:

* IntelliJ Idea Community
* [Java JDK 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html)
* [Maven](https://maven.apache.org/download.cgi) (please follow the steps in the documentation)
* DBeaver (optional, management database access)

## Installation

After to get all pre-requirements and to clone the repository you have two ways in order to execute the automation tests, both of them going to describe follow

### Command Line Interface

```bash
mvn clean
```
```bash
mvn mvn compile
```
```bash
mvn test verify "-Dcucumber"
```
The last command lets to get the report if all the tests passed as expected

### IntelliJ Idea Community

* Go to file -> Project Structure , in the section "Project SDK" select the java version that you installed on pre-requirements (correto-11)
* Go to Run -> Edit Configurations
* Click on "Add New Configuration" and select JUnit
* After to select JUnit right to the window complete the following information

    - Select Java 11 correto-11
    - Select test-api Module
    - Class section click on "Browse" and select the TestRunner class
    - Environments variables please use the followings:

### Service information
  - method: 'GET'
  - url: 'https://covid-19-data.p.rapidapi.com/country/code'
  - params: {code: 'it'}
  - headers: 
    * 'x-rapidapi-host': 'covid-19-data.p.rapidapi.com'
    * 'x-rapidapi-key': '7a0315cd52msh7f1b1b93e127f7cp19bb22jsn084ea8301339'
  

### Asertions needed
    - validate 200 response asertion
    - validate deaths superior number than 0
    - validate an correct latitude and longitude

## Contributing
Chiper Automation Tests Team

## License
Chiper S.A.S
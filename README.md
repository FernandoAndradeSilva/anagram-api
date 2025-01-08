# Anagram Application

## Overview

This is a Spring Boot application that provides an API to generate anagrams for given words. The application includes validation to ensure that the input words meet specific criteria.

## Features

- Generate anagrams for a given word.
- Validate input words to ensure they are not null, empty, or contain special characters or spaces.
- Handle various error scenarios with appropriate responses.

## Technologies Used

- Java
- Spring Boot
- Maven
- JUnit

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8.1 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/FernandoAndradeSilva/anagram-application.git
    cd anagram-application
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Running Tests

To run the tests, use the following command:
```sh
mvn test
# Jumia Tech Test

## Prerequisites

* JDK 1.8
* Maven 3.84


* Spring boot 2.5.12
* thymeleaf

## Getting Started

Build and run the application without the Docker container:
* Build it: `mvnw package`
* Run it: `java -jar target/exercise-0.0.1-SNAPSHOT.jar`
* View it: http://localhost:8080

Build and run the application on a Docker container:
* Build it: `docker build -t springio/exercise`
* Run it: `docker run -p 8080:8080 springio/exercise`
* View it: http://localhost:8080
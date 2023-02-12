# Book Management and Search System (Catalogue Microservice)
## Metrics   

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=bugs)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=DoomFungus_RedLib-catalogue&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=DoomFungus_RedLib-catalogue)

## General

This repository contains a catalogue microservice of a book management and search system developed for Advanced Software Engineering course in the BHT.
It's sister repository containing search microservice can be found [here](https://github.com/DoomFungus/RedLib-search)

The purpose of this system is to provide a simple way to catalogue and search books as part of larger application, such as an online library or a bookstore.

### 1 UML
As part of the documentation, 3 diagrams have been created:
- The [use case diagram](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/diagrams/usecase-redlib.png) shows scenarios in which system can be used as well as involved actors. Relevant PlantUML markup can be found [here](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/diagrams/usecase.txt)
- The [component diagram](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/diagrams/component.png) shows the ways different microservices interact with each other and the external systems. Relevant PlantUML markup can be found [here](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/diagrams/component.txt)
- _add sql diagram when project is more complete_

### 2 DDD

As part of design process, the following domain diagram was created:
[Domain Diagram](https://github.com/DoomFungus/RedLib-catalogue/blob/master/documentation/diagrams/DDD.png)

### 3 Event Storming

### 4 Metrics

SonarQube is used in the project for evaluation, vulnerability detection and metrics generation. The analysis is automatic, occurs during each push to master branch. Sonar analysis can be found [here]{https://sonarcloud.io/project/overview?id=DoomFungus_RedLib-catalogue}

### 5 Clean Code Development

_in progress_


### 6 Build Management
Maven was used as a build management tool. A convention-over-configuration tool, it provides good support for prototyping new projects with Spring, giving the ability to rely on a convention in most cases and reducing boilerplate code.

Maven files (pom.xml) can be found here:
- [Catalogue Service](https://github.com/DoomFungus/RedLib-catalogue/blob/master/pom.xml)
- [Search Service](https://github.com/DoomFungus/RedLib-search/blob/master/pom.xml)


### 7 Testing
_tests are not written yet_

### 8 Continuous Delivery

Github Actions are used to create CI/CD pipeline for automatic test running and building, as well as deployment to Amazon ECS. Amazon deployment includes creating new ECS task definition, uploading image to ECR, running the the task on ECS. Deploy uses EC2 instances with a load balancer. External gateway can be accessed [here]{RedLibBalancer-1382607045.eu-central-1.elb.amazonaws.com}

### 9 DSL

_no example yet_

### 10 Functional Programming

Minor application of functional-stzle programming can be found [here](https://github.com/DoomFungus/RedLib-catalogue/blob/master/src/main/java/edu/bht/ase/redlib/service/impl/BookServiceImpl.java#L31)

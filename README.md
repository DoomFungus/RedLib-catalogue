# Book Management and Search System (Catalogue Microservice)
## Metrics  

_put metrics here_

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

### 3 Event Storming

### 4 Metrics

_put metrics here_

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

_AWS deploy is in progress_

### 9 DSL

_no example yet_

### 10 Functional Programming

Minor application of functional-stzle programming can be found [here](https://github.com/DoomFungus/RedLib-catalogue/blob/master/src/main/java/edu/bht/ase/redlib/service/impl/BookServiceImpl.java#L31)

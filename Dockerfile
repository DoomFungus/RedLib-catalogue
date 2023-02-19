FROM openjdk:17-jdk-alpine

COPY target/RedLib-catalogue-0.0.1-SNAPSHOT.jar redlib-catalogue.jar
ENTRYPOINT ["java","-jar","/redlib-catalogue.jar"]
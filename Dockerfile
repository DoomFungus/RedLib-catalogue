FROM openjdk:17-jdk-alpine
COPY target/RedLib-0.0.1-SNAPSHOT.jar redlib-catalogue.jar
ENTRYPOINT ["java","-jar","/redlib-catalogue.jar"]
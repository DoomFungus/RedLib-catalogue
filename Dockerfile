FROM openjdk:17-jdk-alpine

HEALTHCHECK --interval=30s --timeout=3s CMD curl -f http://localhost:80/catalogue/actuator/health || exit 1

COPY target/RedLib-0.0.1-SNAPSHOT.jar redlib-catalogue.jar
ENTRYPOINT ["java","-jar","/redlib-catalogue.jar"]
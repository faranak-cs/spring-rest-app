FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/spring-rest.jar spring-rest.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-rest.jar"]
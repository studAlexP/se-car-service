FROM openjdk:21-slim-bullseye

COPY target/se-car-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9093

ENTRYPOINT ["java", "-jar", "app.jar"]
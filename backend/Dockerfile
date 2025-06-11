# Use a small, multi-arch JRE base
FROM openjdk:21-jdk-slim AS builder

WORKDIR /app

# Copy your locally built fat-jar
COPY target/ticket-tracker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
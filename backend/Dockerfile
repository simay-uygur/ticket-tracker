# Base image
FROM eclipse-temurin:21-jdk-alpine

# Working directory inside container
WORKDIR /app

# Copy build artifacts (JAR file) — önce mvn clean package ile üretmiş olmalısın
COPY target/ticket-tracker-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

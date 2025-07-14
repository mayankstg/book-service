# Use a lightweight OpenJDK base image
FROM openjdk:17-jdk-slim

# Expose the port your Spring Boot application runs on (e.g., 8080)
EXPOSE 8081

# Copy the executable JAR file into the container
ARG JAR_FILE=target/book-service-0.0.1-SNAPSHOT.jar 
# Adjust path if using Gradle
COPY ${JAR_FILE} app.jar

# Define the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Stage 1: Build the application
FROM maven:3.8.3-openjdk-17 AS build
#WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the final image
FROM openjdk:17-jre-slim
#WORKDIR /app

# Expose the port your Spring Boot application runs on (e.g., 8080)
EXPOSE 8081

# Copy the executable JAR file into the container
ARG JAR_FILE=target/*.jar 
# Adjust path if using Gradle
COPY ${JAR_FILE} app.jar

# Define the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]
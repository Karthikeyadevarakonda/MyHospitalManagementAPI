# Use a base image with JDK
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/HospitalManagement-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (default Spring Boot port is 8080)
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

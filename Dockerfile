# Use Java 21 JDK + Maven installed
FROM maven:3.9.4-eclipse-temurin-21

# Set working directory inside container
WORKDIR /app

# Copy all project files into the container
COPY . .

# Build the Spring Boot jar using Maven
RUN mvn clean package

# Expose port 8080 for the app
EXPOSE 8080

# Start the Spring Boot app
CMD ["java", "-jar", "target/appointment-sms-app-0.0.1-SNAPSHOT.jar"]
FROM openjdk:25-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file
COPY target/*.jar /app/your-app.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/your-app.jar"]
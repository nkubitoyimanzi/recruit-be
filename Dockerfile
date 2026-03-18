# Use lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built jar
COPY target/*.jar app.jar

# Expose port (Render will override with PORT env)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-Dserver.port=${PORT:8080}", "-jar", "app.jar"]
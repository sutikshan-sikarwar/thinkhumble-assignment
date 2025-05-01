# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory in the container
WORKDIR /app

# Copy the built jar into the container
COPY target/thinkhumble-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 5454

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

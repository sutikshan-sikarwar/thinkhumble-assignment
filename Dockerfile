# ---- STAGE 1: Build the application ----
    FROM maven:3.8.5-openjdk-17 AS build
    WORKDIR /app
    
    # Copy only relevant files for efficient Docker cache
    COPY pom.xml .
    COPY src ./src
    
    # Package the application
    RUN mvn clean package -DskipTests
    
    # ---- STAGE 2: Run the application ----
    FROM openjdk:17.0.1-jdk-slim
    WORKDIR /app
    
    # Copy the JAR from the previous stage
    COPY --from=build /app/target/thinkhumble-0.0.1-SNAPSHOT.jar app.jar
    
    # Expose the port your app runs on (as per your application.properties)
    EXPOSE 8080
    
    # Run the application
    ENTRYPOINT ["java", "-jar", "app.jar"]
    
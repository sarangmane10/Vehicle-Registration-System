FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

# First copy the Maven wrapper files
COPY mvnw .
COPY .mvn/ .mvn/

# Then copy the rest of the files
COPY pom.xml .
COPY src ./src

# Build the application
RUN ./mvnw package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
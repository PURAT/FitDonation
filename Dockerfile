# Build stage
FROM maven:3.6.0-jdk-13-alpine AS build
COPY . .
RUN mvn clean package -DskipTests -P release

# Package stage
FROM openjdk:13-jdk-alpine3.10
COPY --from=build /target/fitdonation-0.0.1-SNAPSHOT.jar fitdonation.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","fitdonation.jar"]
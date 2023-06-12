FROM eclipse-temurin:20-jdk-alpine

WORKDIR /backend

COPY pom.xml ./
COPY mvnw ./
COPY .mvn ./.mvn
COPY system.properties ./
COPY src ./src

RUN chmod +x mvnw
RUN ./mvnw install

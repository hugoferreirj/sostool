FROM eclipse-temurin:20-jdk-alpine

WORKDIR /backend

COPY pom.xml ./
COPY mvnw ./
COPY .mvn ./.mvn
COPY system.properties ./
COPY src ./src

EXPOSE 8081

RUN chmod +x mvnw
RUN ./mvnw install

CMD [ "java", "-jar", "target/sostool-backend-0.0.1-SNAPSHOT.jar" ]

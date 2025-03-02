# Description: Dockerfile for the board-game-store-service builder and dependencies. Air tight container for the board-game-store-service
FROM maven:3.9.9-eclipse-temurin-23-alpine AS DEPENDENCIES

WORKDIR /opt/app


COPY board-game-persistance/pom.xml  board-game-persistance/pom.xml
COPY board-game-persistance-spring-boot-autoconfigure/pom.xml board-game-persistance-spring-boot-autoconfigure/pom.xml
COPY board-game-persistance-spring-boot-starter/pom.xml board-game-persistance-spring-boot-starter/pom.xml
COPY board-game-store-service/pom.xml board-game-store-service/pom.xml
COPY pom.xml .

RUN mvn -B -e org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline 

FROM maven:3.9.9-eclipse-temurin-23-alpine AS BUILDER

WORKDIR /opt/app
COPY --from=DEPENDENCIES /root/.m2 /root/.m2
COPY --from=DEPENDENCIES /opt/app/ /opt/app
COPY board-game-persistance/src /opt/app/board-game-persistance/src
COPY board-game-persistance-spring-boot-autoconfigure/src /opt/app/board-game-persistance-spring-boot-autoconfigure/src
COPY board-game-store-service/src /opt/app/board-game-store-service/src

RUN mvn -B -e clean install -DskipTests

FROM openjdk:25-slim

WORKDIR /opt/app
#COPY --from=BUILDER /opt/app/api/target/*.jar /app.jar
COPY --from=BUILDER /opt/app/board-game-store-service/target/*.jar /app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]

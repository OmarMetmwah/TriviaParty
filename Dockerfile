# Build stage
FROM maven:3.9.6-sapmachine-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Package stage
FROM openjdk:21
ENV PORT 8081
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","app.jar"]
FROM maven:3.9.6-eclipse-temurin-8 AS build

WORKDIR /app

COPY . .

RUN mvn clean package

FROM tomcat:9.0

COPY --from=build /app/target/CursoWebJava-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
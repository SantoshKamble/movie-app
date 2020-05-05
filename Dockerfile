FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/movies-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} movies-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","movies-app-0.0.1-SNAPSHOT.jar"]
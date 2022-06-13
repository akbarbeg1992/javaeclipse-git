FROM openjdk:17-jdk-slim-buster
EXPOSE 8080
ARG JAR_FILE=target/test-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} test.jar
ENTRYPOINT ["java","-jar","/test.jar"]
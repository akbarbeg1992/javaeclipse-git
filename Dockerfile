# FROM openjdk:17-jdk-slim-buster
# EXPOSE 8080
# ARG JAR_FILE=target/test-0.0.1-SNAPSHOT.jar
# ADD ${JAR_FILE} test.jar

# WORKDIR /app

# COPY --from=maven_build /build/target/*.jar /app/test.jar

# ENTRYPOINT ["java", "-jar", "test.jar"]

# ENTRYPOINT ["java","-jar","/*.jar"]


# healthcheck
# springboot actuator healthckeck



######### IMAGE BUILD ############
FROM maven:3.8.5-amazoncorretto-11 AS MAVEN_BUILD
EXPOSE 8080

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package -Dmaven.test.skip=true

######### PROD IMAGE ARTIFACT COPY #############

FROM amazoncorretto:11
EXPOSE 8080

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/siesma-test.jar

ENTRYPOINT ["java", "-jar", "siesma-test.jar"]
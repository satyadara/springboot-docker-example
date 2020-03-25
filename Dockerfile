FROM openjdk:8-jdk-alpine
MAINTAINER satyadara.com
VOLUME /tmp
EXPOSE 9000
ARG JAR_FILE=build/libs/simple-docker-example-0.0.1-SS.jar
ADD ${JAR_FILE} springbootdockerexample.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/springbootdockerexample.jar"]
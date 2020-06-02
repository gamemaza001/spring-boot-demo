# Use official base image of Java Runtime
FROM openjdk:8-jdk-alpine
# Maintainer image
MAINTAINER gamemaza001@gmail.com
# Set volume point to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside container
EXPOSE 8080
COPY ./target/demo-0.0.1-SNAPSHOT.jar /app/app.jar
# Set application's JAR file
#ARG JAR_FILE=target/docker-0.0.1-SNAPSHOT.jar
# Add the application's JAR file to the container
#ADD ${JAR_FILE} app.jar
# Run the JAR file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
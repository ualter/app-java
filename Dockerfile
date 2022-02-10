FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG IMAGE_TAG
ARG JAR_FILE=target/app-${IMAGE_TAG}.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
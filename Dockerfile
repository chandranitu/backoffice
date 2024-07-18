FROM openjdk:17-jdk-slim
EXPOSE 8082:8082
ADD /target/backoffice-0.0.1-SNAPSHOT.jar backoffice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","backoffice-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17-jdk-slim
EXPOSE 8082:8082
ADD /target/orderservice-0.0.1-SNAPSHOT.jar orderservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","orderservice-0.0.1-SNAPSHOT.jar"]

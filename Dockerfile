FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/restapp-0.0.1-SNAPSHOT.jar todo.jar
ENTRYPOINT ["java","-jar","/todo.jar"]
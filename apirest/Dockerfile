FROM openjdk:8
EXPOSE 8082
ADD ./target/apirest-0.0.1-SNAPSHOT.jar api-rest-docker.jar
ENTRYPOINT ["java","-jar","/api-rest-docker.jar"]
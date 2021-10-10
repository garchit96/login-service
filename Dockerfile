FROM openjdk:8
ADD target/Login-service.jar Login-service.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar","Login-service.jar"]
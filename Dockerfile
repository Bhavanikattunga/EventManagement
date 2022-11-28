FROM openjdk:8
ADD target/EventManagement-0.0.1-SNAPSHOT.jar EventManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","EventManagement-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
FROM eclipse-temurin:21-jre

WORKDIR /lab

COPY target/Book_Application-0.0.1-SNAPSHOT.jar lab.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "lab.jar"]
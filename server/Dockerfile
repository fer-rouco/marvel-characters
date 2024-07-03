FROM amazoncorretto:21-alpine-jdk

COPY ./target/server-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-jar", "/app.war"]

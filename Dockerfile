FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/server-0.0.1-SNAPSHOT.jar marvelcharacters.jar
EXPOSE 8888
EXPOSE 4200
ENTRYPOINT exec java $JAVA_OPTS -jar marvelcharacters.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar marvelcharacters.jar

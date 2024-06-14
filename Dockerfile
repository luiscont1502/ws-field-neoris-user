FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/ws-field-neoris-user-0.0.1-SNAPSHOT.war user-service.war
ENTRYPOINT ["java","-jar","/user-service.war"]

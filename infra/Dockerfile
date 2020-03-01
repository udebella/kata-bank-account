FROM openjdk:11

COPY target/infra-1.0-SNAPSHOT-executable.jar .

EXPOSE 8080/tcp
CMD ["java",  "-jar", "infra-1.0-SNAPSHOT-executable.jar"]
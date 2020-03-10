FROM maven:3.6.3-jdk-11-openj9

COPY . .

RUN mvn package

EXPOSE 8080/tcp
CMD ["java",  "-jar", "infra/target/infra-1.0-SNAPSHOT-executable.jar"]
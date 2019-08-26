# pull jdk image
FROM openjdk:11
# add/copy jar file from target to docker file system
ADD ./target/rabbitmq-listener-0.0.1-SNAPSHOT.jar /usr/src/rabbitmq-listener-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
# run the jar file
ENTRYPOINT ["java","-jar","rabbitmq-listener-0.0.1-SNAPSHOT.jar"]
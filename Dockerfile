FROM openjdk:21-jdk-slim
ADD /build/libs/*.jar demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/demo.jar"]
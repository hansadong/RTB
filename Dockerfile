FROM openjdk:21
ADD /build/libs/*.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]
FROM openjdk:11.0.3-jdk-stretch
ADD /target/spring-eureka-server-0.0.1-SNAPSHOT.jar /app/track/spring-eureka-server-0.0.1-SNAPSHOT.jar
WORKDIR /app/track
ENTRYPOINT ["java","-jar","spring-eureka-server-0.0.1-SNAPSHOT.jar"]
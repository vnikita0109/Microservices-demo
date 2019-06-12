FROM openjdk:11.0.3-jdk-stretch
ADD /target/springgatewayapi-0.0.1-SNAPSHOT.jar /app/track/springgatewayapi-0.0.1-SNAPSHOT.jar
WORKDIR /app/track
ENTRYPOINT ["java","-jar","springgatewayapi-0.0.1-SNAPSHOT.jar"]
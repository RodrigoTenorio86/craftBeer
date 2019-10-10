FROM openjdk:8
MAINTAINER 
ADD target/craft-beer-1.0.jar
ENTRYPOINT ["java", "-jar", "craft-beer-1.0.jar"]
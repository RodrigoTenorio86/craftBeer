FROM openjdk:8
MAINTAINER RODRIGO TENORIO DE BOA VENTURA<boaventura19@yahoo.com.br>
ADD target/craft-beer-1.0.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "craft-beer-1.0.jar"]

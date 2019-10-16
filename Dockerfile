FROM openjdk:8
MAINTAINER RODRIGO TENORIO DE BOA VENTURA<boaventura19@yahoo.com.br>
ADD target/craft-beer.jar	craft-beer.jar
COPY	target/craft-beer.jar	craft-beer.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "craft-beer.jar"]

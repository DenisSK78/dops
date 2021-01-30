FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-alpine
ADD . /src
WORKDIR /src
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/dops-0.0.1-SNAPSHOT.jar"]


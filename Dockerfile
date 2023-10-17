FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/todolist-0.0.1.jar app.jar

# ENTRYPOINT [ "java", "-jar", "app.jar" ]
# FROM openjdk:17-jdk-alpine
# VOLUME /tmp
# COPY ${JAR_FILE} /todolist.jar
# ENTRYPOINT ["java","-jar","/todolist.jar"]
# EXPOSE 8080:8080



# Ubuntu 
# FROM ubuntu:latest As build
# RUN apt-get update
# RUN apt-get install openjdk-17-jdk -y
# COPY . .
# RUN apt-get install maven -y
# RUN mvn clean install
# EXPOSE 8080
# COPY --from=build /target/todolist-1.0.0.jar app.jar
# ENTRYPOINT [ "java", "-jar", "app.jar"]
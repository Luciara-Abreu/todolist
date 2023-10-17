FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
# COPY ${JAR_FILE} app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080:8080





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
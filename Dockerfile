FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/franquiciaProductos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_franquiciaProductos.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_franquiciaProductos.jar"]
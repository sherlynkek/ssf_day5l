FROM openjdk:23-jdk

ARG app-dir=/app
ARG port=4000

WORKDIR ${app-dir}

COPY .mvn .mvn
COPY src src
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .

RUN ./mvnw clean package -Dmaven.tests.skip=true

ENV SERVER_PORT 4000

EXPOSE ${SERVER_PORT}

# run application using ENTRYPOINT or CMD
ENTRYPOINT ["java", "-jar", ""]
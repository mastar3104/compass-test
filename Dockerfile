FROM openjdk:17 AS build
WORKDIR /app

COPY . /app

RUN microdnf install findutils
RUN ./gradlew clean build

FROM openjdk:17-jdk-slim
WORKDIR /app

COPY --from=build /app/build/libs/compass-test-0.0.1-SNAPSHOT.jar /app/

EXPOSE 8080

CMD ["java", "-jar", "/app/compass-test-0.0.1-SNAPSHOT.jar"]
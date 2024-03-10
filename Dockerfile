FROM adoptopenjdk/openjdk:21-slim

COPY target/kata-0.0.1-SNAPSHOT.jar /app/kata-0.0.1-SNAPSHOT.jar

WORKDIR /app

CMD ["java", "-jar", "kata-0.0.1-SNAPSHOT.jar"]

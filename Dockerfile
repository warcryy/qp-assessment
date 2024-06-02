FROM openjdk:17-alpine
WORKDIR /app
COPY target/assesement.war /app
CMD ["java", "-jar", "assesement.war"]

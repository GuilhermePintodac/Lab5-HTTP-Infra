FROM alpine:latest
RUN apk add --no-cache openjdk21
WORKDIR /HTTP-API
COPY target/app.jar /app.jar
# This is the port that your javalin application will listen on
EXPOSE 7777
ENTRYPOINT ["java", "-jar", "/app.jar"]

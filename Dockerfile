FROM openjdk:17
VOLUME /data /tmp
ADD target/Chat-to-ChatGPT*.jar /app.jar
CMD ["java","-jar","/app.jar","--spring.profiles.active=prod"]
EXPOSE 8080
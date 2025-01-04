FROM openjdk:17-jdk-slim-buster

COPY ./webapp.jar /webapp.jar
COPY ./start.sh /start.sh

RUN chmod +x /start.sh

EXPOSE 8080

ENTRYPOINT ["/start.sh"]
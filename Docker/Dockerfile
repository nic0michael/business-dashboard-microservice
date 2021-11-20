FROM alpine:latest
WORKDIR /
VOLUME /tmp
ADD antenna-dashboard.war antenna-dashboard.jar
RUN apk --update add openjdk11-jre
EXPOSE 8085
CMD java -Xmx500M -jar antenna-dashboard.jar

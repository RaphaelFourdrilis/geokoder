FROM openjdk:8-jre-alpine

COPY ./geokoder.jar /root/geokoder.jar

WORKDIR /root

CMD ["java", "-server", "-Xms2g", "-Xmx2g", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "geokoder.jar"]
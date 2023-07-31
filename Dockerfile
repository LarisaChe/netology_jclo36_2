FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY build/libs/netology_jclo36_2-0.0.1-SNAPSHOT.jar apptask4n.jar

CMD ["java", "-jar", "apptask4n.jar"]
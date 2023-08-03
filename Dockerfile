FROM openjdk:17-jdk-alpine

EXPOSE 8081

ADD build/libs/netology_jclo36_2-0.0.1-SNAPSHOT.jar apptask5.jar

ENTRYPOINT ["java","-jar","/apptask5.jar"]
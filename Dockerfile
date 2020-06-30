FROM openjdk:14-alpine
COPY build/libs/seiss-validation-service-*-all.jar seiss-validation-service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "seiss-validation-service.jar"]
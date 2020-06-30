FROM openjdk:14-alpine
COPY build/libs/test-service-*-all.jar test-service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "test-service.jar"]
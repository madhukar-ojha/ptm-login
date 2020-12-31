FROM openjdk:11
COPY ./target/ptm-login.jar .

WORKDIR .
EXPOSE 7080
RUN sh -c 'touch ptm-login.jar'
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "ptm-login.jar"]
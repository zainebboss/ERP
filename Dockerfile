From openjdk:8
EXPOSE 8083
ADD /target/ccc.jar ccc.jar
ENTRYPOINT ["java", "-jar", "ccc.jar"]
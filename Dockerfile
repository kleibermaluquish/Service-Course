FROM openjdk:8
VOLUME /tmp
EXPOSE 8040
ADD ./target/ServiceCourse-0.0.1-SNAPSHOT.jar config-course.jar
ENTRYPOINT ["java","-jar","/config-course.jar"]
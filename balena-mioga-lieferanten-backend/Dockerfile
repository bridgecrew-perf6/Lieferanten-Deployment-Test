ARG JDK_VERSION=11
FROM balenalib/genericx86-64-ext-debian-openjdk:$JDK_VERSION AS build

RUN install_packages ca-certificates wget git openssh-client gawk bzip2 maven

ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
RUN mkdir -p /application
#RUN cd /application
RUN mkdir -m 700 /root/.ssh; \
  touch -m 600 /root/.ssh/known_hosts; \
  ssh-keyscan github.com > /root/.ssh/known_hosts

COPY . /application/backend

#RUN --mount=type=ssh,id=github git clone https://github.com/thaupt76/DistributedWorkingClassHelper.git /application/backend

RUN cd /application/backend && mvn package && cp target/docker-spring-boot.jar /docker-spring-boot.jar ;

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/docker-spring-boot.jar"]
#CMD ["java", "-cp", "/docker-spring-boot.jar"]

VOLUME /application/backend


# older
#FROM openjdk:11
#ADD target/docker-spring-boot.jar docker-spring-boot.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
#
#COPY . /usr/src/main
#WORKDIR /usr/src/myapp
#RUN javac Main.java
#CMD ["java", "Main"]

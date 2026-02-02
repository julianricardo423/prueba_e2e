FROM jenkins/jenkins:lts

USER root

RUN apt update && apt install git -y
COPY apache-maven-3.8.8-bin.tar.gz /opt
WORKDIR /opt
RUN tar -C /opt -xzvf /opt/apache-maven-3.8.8-bin.tar.gz
ENV MAVEN_HOME=/opt/apache-maven-3.8.8/
ENV PATH=/opt/apache-maven-3.8.8/bin:$PATH
RUN git clone -b main https://github.com/julianricardo423/prueba_e2e.git
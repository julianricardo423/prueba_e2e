FROM jenkins/jenkins:lts

USER root

RUN apt update && apt install git -y
WORKDIR /opt/
ENV MAVEN_HOME=/opt/apache-maven-3.8.8/
ENV PATH=/opt/apache-maven-3.8.8/bin:$PATH
RUN git clone -b main https://github.com/julianricardo423/prueba_e2e.git
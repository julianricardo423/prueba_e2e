FROM jenkins/jenkins:lts

USER root

COPY apache-maven-3.8.8-bin.tar.gz /opt
WORKDIR /opt
COPY pom.xml /opt
RUN tar -C /opt -xzvf /opt/apache-maven-3.8.8-bin.tar.gz
ENV MAVEN_HOME=/opt/apache-maven-3.8.8/
ENV PATH=/opt/apache-maven-3.8.8/bin:$PATH
# Instalar Docker CLI
RUN curl -fsSL https://get.docker.com | sh

# Instalar Docker Compose (plugin)
RUN mkdir -p /usr/local/lib/docker/cli-plugins \
    && curl -SL https://github.com/docker/compose/releases/download/v2.25.0/docker-compose-linux-x86_64 \
    -o /usr/local/lib/docker/cli-plugins/docker-compose \
    && chmod +x /usr/local/lib/docker/cli-plugins/docker-compose
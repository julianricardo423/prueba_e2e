FROM jenkins/jenkins:lts

USER root

ENV MAVEN_VERSION=3.8.8
ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

RUN apt-get update && apt-get install -y docker.io curl tar && \
curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
| tar -xz -C /opt && \
ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven && \
mkdir -p /usr/local/lib/docker/cli-plugins && \
curl -SL https://github.com/docker/compose/releases/download/v2.29.2/docker-compose-linux-x86_64 \
-o /usr/local/lib/docker/cli-plugins/docker-compose && chmod +x /usr/local/lib/docker/cli-plugins/docker-compose && \
apt-get clean && rm -rf /var/lib/apt/lists/*

USER jenkins
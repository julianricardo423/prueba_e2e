pipeline {
agent any
environment {
    BROWSERSTACK_USERNAME = credentials('browserstack-username')
    BROWSERSTACK_ACCESS_KEY = credentials('browserstack-access-key')
}
stages {
    stage('Build') {
        steps {
            withMaven(maven: 'maven-3.8.8') {
                sh 'mvn --version'
                sh 'mvn clean verify'
                }
            }
        }
    }
}

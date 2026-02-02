pipeline {
agent any
environment {
    BROWSERSTACK_USERNAME = credentials('BROWSERSTACK_USERNAME')
    BROWSERSTACK_ACCESS_KEY = credentials('BROWSERSTACK_ACCESS_KEY')
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

pipeline {
    agent any

    stages {

        stage('Levantar servicios') {
            steps {
                sh 'docker-compose up -d'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw --version'
                sh './mvnw clean verify'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
        }
    }
}


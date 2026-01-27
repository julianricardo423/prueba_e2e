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
                sh 'mvn clean verify'
                // o gradle test / serenity aggregate, según tu stack
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
        }
    }
}


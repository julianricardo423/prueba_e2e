pipeline {
    agent any

    stages {

        stage('Levantar servicios') {
            steps {
                sh 'docker compose up -d'
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh 'mvn --version'
            }
        }
    }

    post {
        always {
            sh 'docker compose down'
        }
    }
}


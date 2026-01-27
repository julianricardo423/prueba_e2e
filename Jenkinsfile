pipeline {
    agent any

    stages {
        stage('Ejecutar pruebas') {
            steps {
                sh 'mvn --version'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
        }
    }
}


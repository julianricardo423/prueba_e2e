pipeline {
    agent any
    stages {
        stage('Levantar servicios') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}

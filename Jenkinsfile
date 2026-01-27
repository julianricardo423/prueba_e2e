pipeline {
agent any 
  stages {
    stage('Levantar servicios') {
      steps {
        sh 'docker compose up -d'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn --version'
        sh 'mvn clean verify'
      }
    }
  }

  post {
    always {
      sh 'docker compose down'
    }
  }
}

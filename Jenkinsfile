pipeline {
  agent any

  stages {

    stage('Levantar servicios y Test') {
      steps {
        withCredentials([
        string(credentialsId: 'BROWSERSTACK_USERNAME', variable: 'BROWSERSTACK_USERNAME'),
        string(credentialsId: 'BROWSERSTACK_ACCESS_KEY', variable: 'BROWSERSTACK_ACCESS_KEY')
        ]) {
          sh '''
            mvn clean verify
          '''
        }
      }
    }
  }

  post {
    always {
      sh 'docker compose down'
    }
  }
}
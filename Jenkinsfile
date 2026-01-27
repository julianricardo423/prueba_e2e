pipeline {
  agent any

  stages {

    stage('Levantar servicios') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: 'user_browserstack',
          usernameVariable: 'USER_BROWSERSTACK',
          passwordVariable: 'KEY_BROWSERSTACK'
        )]) {
          sh '''
            docker compose up -d
          '''
        }
      }
    }

    stage('Test') {
      steps {
        sh '''
          docker compose run --rm tests mvn clean verify
        '''
      }
    }
  }

  post {
    always {
      sh 'docker compose down'
    }
  }
}

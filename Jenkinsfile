pipeline {
  agent any

  stages {

    stage('Levantar servicios') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: 'user_browserstack',
          usernameVariable: 'BROWSERSTACK_USERNAME',
          passwordVariable: 'BROWSERSTACK_ACCESS_KEY'
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

pipeline {
  agent any

  stages {

    stage('Levantar servicios y Test') {
      steps {
        withCredentials([usernamePassword(
          credentialsId: 'user_browserstack',
          usernameVariable: 'BROWSERSTACK_USERNAME',
          passwordVariable: 'BROWSERSTACK_ACCESS_KEY'
        )]) {
          sh '''

            echo "$BROWSERSTACK_USERNAME"

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

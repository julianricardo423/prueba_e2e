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
            export BROWSERSTACK_USERNAME
            export BROWSERSTACK_ACCESS_KEY

            echo "$BROWSERSTACK_USERNAME"

            docker compose run --rm -v "${WORKSPACE}:/usr/src/app" tests mvn clean verify

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

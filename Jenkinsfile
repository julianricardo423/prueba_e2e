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

            cd /var/jenkins_home/workspace/my-pipeline
            ls
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

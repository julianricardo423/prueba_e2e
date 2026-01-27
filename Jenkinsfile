pipeline {
agent any
  stages {
    stage('Levantar servicios') {
      steps {
        withCredentials([usernamePassword(
            credentialsId: 'user_browserstack',
            usernameVariable: 'BROWSERSTACK_USERNAME',
            passwordVariable: 'BROWSERSTACK_USERNAME'
            )])
        sh '''
        export BROWSERSTACK_USERNAME
        export BROWSERSTACK_USERNAME
        docker compose up -d'''
      }
    }

    stage('Test') {
      steps {
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

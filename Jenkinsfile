pipeline {
  agent any

  stages {

    stage('Levantar servicios') {
      steps {
        sh 'docker-compose up -d --build'
      }
    }

    stage('Ejecutar pruebas') {
      steps {
        withCredentials([
          string(credentialsId: 'BROWSERSTACK_USERNAME', variable: 'BROWSERSTACK_USERNAME'),
          string(credentialsId: 'BROWSERSTACK_ACCESS_KEY', variable: 'BROWSERSTACK_ACCESS_KEY')
        ]) {
          sh 'docker-compose exec tests mvn clean verify'
        }
      }
    }
  }

  post {
    always {
      sh 'docker-compose down'
    }
  }
}

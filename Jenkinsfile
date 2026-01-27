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
                export USER_BROWSERSTACK
                export KEY_BROWSERSTACK

                docker compose down -v
                docker compose up -d
              '''
            }
          }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh '''
                      docker compose exec tests mvn clean verify
                    '''
            }
        }
    }
}

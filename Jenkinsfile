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
              '''
            }
          }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh '''
                      mvn clean verify
                    '''
            }
        }
    }
}

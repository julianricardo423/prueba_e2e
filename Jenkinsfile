pipeline {
    agent any

    environment {
        BROWSERSTACK = credentials('browserstack-creds')
    }

    stages {

        stage('Levantar servicios') {
            steps {
                sh '''
                  export USER_BROWSERSTACK=$BROWSERSTACK_USR
                  export KEY_BROWSERSTACK=$BROWSERSTACK_PSW

                  docker compose up -d
                '''
            }
        }

        stage('Ejecutar pruebas') {
            steps {
                sh '''
                  export USER_BROWSERSTACK=$BROWSERSTACK_USR
                  export KEY_BROWSERSTACK=$BROWSERSTACK_PSW

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

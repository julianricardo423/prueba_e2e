pipeline {
    agent any

    environment {
        BROWSERSTACK = credentials('user_browserstack')
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
                      docker compose run --rm \
                        -v "$WORKSPACE:/src" \
                        -w /src \
                        tests mvn clean verify
                    '''
            }
        }
    }
}

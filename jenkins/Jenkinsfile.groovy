pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Check Working Directory') {
            steps {
                sh "pwd"
            }
        }
    }
}

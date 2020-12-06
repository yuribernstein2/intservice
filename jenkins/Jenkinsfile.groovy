pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                dir('CoolNewDirectory') {
                    git branch: 'main', credentialsId: 'github_cred', url: 'https://github.com/yuribernstein2/intservice.git'
                    echo 'Hello World'
                }
            }
        }
        stage('Check Working Directory') {
            steps {
                sh "pwd"
            }
        }
    }
}

def userInput

pipeline {
    agent any

    stages {
        stage('Input') {
            steps {
                script {
                    userInput = input message: 'Please provide your input', ok: 'confirm', parameters: [choice(name: '', choices: ['option 1', 'option2'], description: '')]
                }
            }
        }
        stage('Hello') {
            steps {
                dir('CoolNewDirectory') {
                    git branch: 'main', credentialsId: 'github_cred', url: 'https://github.com/yuribernstein2/intservice.git'
                    echo 'Hello World'
                }
            }
        }
        stage('Print Inputed string') {
            steps {
                println("Input was " + userInput)
            }
        }
    }
}

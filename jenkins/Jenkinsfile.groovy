def userInput

pipeline {

    agent {
        label 'docker-node'
    }

    stages {
        stage('Build Docker image') {
            steps {
                dir('intservice'){
                    script {
                        sh "sudo docker build -t intservice ."
                    }
                }
            }
        }
        stage('Test Docker image') {
            steps {
                dir('intservice/tests') {
                    script{
                        try {
                            sh "sh ./basic.test.sh"
                        } catch (err) {
                            println("Error thrown on test file execution")
                        }
                    }
                }
            }
        }
        stage('Upload image to repository') {
            steps {
                sh "pwd"
            }
        }
        stage('Print Inputed string') {
            steps {
                println("Empty stage")
            }
        }
    }
}







//def userInput
//
//pipeline {
//
//    label docker-node
//
//    stages {
//        stage('Input') {
//            steps {
//                script {
//                    userInput = input message: 'Please provide your input', ok: 'confirm', parameters: [choice(name: '', choices: ['option 1', 'option2'], description: '')]
//                }
//            }
//        }
//        stage('Hello') {
//            steps {
//                dir('CoolNewDirectory') {
//                    git branch: 'main', credentialsId: 'github_cred', url: 'https://github.com/yuribernstein2/intservice.git'
//                    echo 'Hello World'
//                }
//            }
//        }
//        stage('Print Inputed string') {
//            steps {
//                println("Input was " + userInput)
//            }
//        }
//    }
//}

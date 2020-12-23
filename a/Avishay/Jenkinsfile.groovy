def userInput

pipeline {

    agent {
        label 'docker_node'
    }
    stages {
        stage('Build Docker image') {
            steps {
                dir('./') {
                    script {
                        sh "sudo docker build -t superhero ."
                    }
                }
            }
        }
        stage('Test Docker Image') {
            steps {
                dir ('./tests') {
                    script{
                        sh "sudo chmod 755 basic.test.sh"
                        sh "./basic.test.sh"
                    }
                }
            }
        }
        stage('Upload Image to repository') {
            steps {
                script {
                    println("We will upload the image to central repository here")
                }
            }
        }
        stage('Run Deployment') {
            steps {
                script {
                    println("We will deploy here")
                }
            }
        }
    }
}

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
                            sh "./basic.test.sh"
                        } catch (err) {
                            println("Error thrown on test file execution")
                            currentBuild.result = 'ABORTED'
                            error('Error thrown on test file execution')
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
        stage('Deploy to Prod') {
            steps {
                println("Empty stage")

                1. make sure docker engine is installed and running
                apt -y install docker.io
                systemctl start docker
                systemctl enable docker

                2. copy the docker image to the target server
                docker save intservice:latest > /var/jenkins_home/intService/intservice.tar    || docker.hub docker push docker.io/intservice/intservice:latest
                scp "/var/jenkins_home/intService/intservice.tar ubuntu@${prod_server_ip}:/tmp"

                3. run the container
                ssh ubuntu@${prod_server_ip} sudo docker load < /tmp/intservice.tar
                ssh ubuntu@${prod_server_ip} sudo docker run -d intservice

                4. make sure it is executed correctly
                ./bash.test.sh

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

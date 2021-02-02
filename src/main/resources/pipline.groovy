pipeline {
    agent any

    stages {
        stage('Checkout Source') {
            steps {
                git url: 'https://github.com/DenisSK78/dops.git', branch: 'master'
            }
        }
        stage('Build project') {
            steps {
                sh "mvn clean package"
            }
        }
        stage('Docker image') {
            steps {
                sh "docker build -t local/dops:latest ."
            }
        }
        stage('Apply kube') {
            steps {
                withKubeConfig([credentialsId: 'project_config']) {
                    sh 'kubectl apply -f src/main/resources/deployment.yml'
                }
            }
        }
    }
}
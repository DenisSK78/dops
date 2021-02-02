pipeline {
    environment {
        registry = "denis78/dops"
        registryCredential = 'dockerhub'
    }
    agent any

    stages {
        stage('Checkout Source') {
            steps {
                git url: 'https://github.com/DenisSK78/dops.git', branch: 'master'
            }
        }
        stage('Build project') {
            steps {
                sh "mvn clean package -Dmaven.test.skip=true"
            }
        }
        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" , "--network host ."
                }
            }
        }
        stage('Deploy image') {
            steps{
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Apply kube') {
            steps {
                withKubeConfig([credentialsId: 'project_config']) {
                    sh 'kubectl apply -f src/main/resources/deployment.yml'
                }
            }
        }
        stage('Remove image') {
            steps{
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }

    post {
        success {
            slackSend channel: '#ht',
                    color: 'good',
                    message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }

        failure {
            slackSend channel: '#ht',
                    color: 'danger',
                    message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More info at: ${env.BUILD_URL}"
        }
    }
}
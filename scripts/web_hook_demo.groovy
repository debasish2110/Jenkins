pipeline {
    agent any  // Runs on any available Jenkins agent

    triggers {
        githubPush()  // Triggered by GitHub Webhook push events
    }

    environment {
        REPO_URL = 'https://github.com/debasish2110/Jenkins.git'
    }

    stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning repository...'
                git branch: 'master', url: "${REPO_URL}"
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                sh 'echo "Simulating a build process..."'  // Dummy build step
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'echo "Running dummy tests..."'  // Dummy test command
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                sh 'echo "Simulating deployment process..."'  // Dummy deployment step
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()  // Cleans the workspace after execution
        }
    }
}

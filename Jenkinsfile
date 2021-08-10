@Library('shared-lib') _
pipeline{
    agent any
    stages{
        stage('Validate'){
            steps{
                sh 'mvn validate'
            }
        }
        stage('Clean'){
            steps{
                sh 'mvn clean'
            }
        }
        stage('Lint Code'){
            steps{
                sh 'mvn checkstyle:check'
            }
        }
        stage('Unit Test'){
            steps{
                sh 'mvn test'
        }

        }

        stage('Mattermost notification') {
	        steps {
                mattermostNotify(currentBuild.currentResult)
            }
        }
      
    }
}

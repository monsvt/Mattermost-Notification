@Library('shared-lib') _
    pipeline {
        agent any
        stages {
            stage("echo hello") {
                steps {
                    echo "hello"
                }
            }
        }
      post {
	        always {
                mattermostNotify(currentBuild.currentResult)
            }
        }
    }

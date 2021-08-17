@Library('shared-lib') _
    pipeline {
        agent any
        stages {
            stage("Build") {
                steps {
                    buildMvn()
                }
            }
        }
      post {
	        always {
                mattermostNotify(currentBuild.currentResult)
            }
        }
    }

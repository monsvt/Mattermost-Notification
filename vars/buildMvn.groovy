def call(body) {
    node {
        stage('Checkout and set agent'){

            echo "found the agentLabel value"
        }
    }

    pipeline {
        agent any
        stages {
            stage("echo parameters") {
                steps {
                    echo "hello"
                }
            }
            
      post {
	        always {
                mattermostNotify(currentBuild.currentResult)
            }
        }
     }
   }
}

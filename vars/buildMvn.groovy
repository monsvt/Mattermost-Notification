def call() {
    pipeline {
        agent any
        stages {
            stage("echo parameters") {
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
}

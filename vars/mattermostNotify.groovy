#!/usr/bin/env groovy

def notification(String buildResult) {
  mattermostSend (color: "#2A42EE", message: "Build STARTED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)")        
  if ( buildResult == "SUCCESS" ) {
    mattermostSend ( color: "good", message: "Build was SUCCESSFUL: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)")
  }
  else {
     mattermostSend ( color: "danger", message: "Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Link to build>)")
  }
}

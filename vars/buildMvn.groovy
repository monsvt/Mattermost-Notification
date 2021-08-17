def call(config){
    try{
        println("[INFO] Build MAVEN Project:")
        sh "mvn -B clean install"
    }
    catch(Exception e){
        println("[ERROR] While running MAVEN Build: ${e}")
    }
}

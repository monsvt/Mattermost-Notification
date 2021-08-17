def call(config){
    try{
        println("[INFO] Build MAVEN Project:")
        sh "mvn -B clean install"
    }
    catch(Exeption e){
        println("[ERROR] While running MAVEN Build: ${e}")
    }
}

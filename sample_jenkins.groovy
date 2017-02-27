def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        stage ('First Stage'){
            echo "This is first stage"
            writeFile file:'Dockerfile', text:libraryResource("Dockerfile")
            sh "ls -lrt"
        }
        stage('Second Stage'){
            echo "This is second stage"
        }
    }
}
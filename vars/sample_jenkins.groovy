import groovy.json.JsonSlurper

def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        stage ('First Stage'){

            //writeFile file:'newports.text', text:libraryResource("/ports.json")
            def inputJson = new JsonSlurper().parseText(libraryResource("/ports.json"))
            portnumber = inputJson.vzt-cache-listener-remotecommandsrequest
            echo "${portnumber}"


        }
        stage('Second Stage'){
            echo "This is second stage"
        }
    }
}
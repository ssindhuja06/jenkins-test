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
            portnumber = inputJson.port
            //def keys = JsonSlurper.keySet()

            Map jsonResult = (Map) inputJson
            echo "${jsonResult}"
            def name = jsonResult.get("123")
            //echo "${jsonResult.keySet()}"
            echo "name is ${name}"
            echo "The port number is"
            //echo "${x}"


        }
        stage('Second Stage'){
            echo "This is second stage"
        }
    }
}
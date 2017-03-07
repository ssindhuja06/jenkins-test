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

            echo "${config.name}"

            if ("${config.name}" == null){
                echo "the param is null"
            }

            def xname = "${config.name}"
            echo "${xname}"
            def myVal = null

            if(myVal == null){
                echo "myVal is null"
            }

            if( xname == null){
                echo "xname is null"
            }

            if ("${config.name}" == null){
                echo "null value passed"
                xname = "master"
                echo "${xname}"
            }
            echo "outside if"
/*
            //writeFile file:'newports.text', text:libraryResource("/ports.json")
            def inputJson = new JsonSlurper().parseText(libraryResource("/ports.json"))
           // portnumber = inputJson.port
           // def keys = JsonSlurper.keySet()

            Map jsonResult = (Map) inputJson
            for (e in jsonResult){
               // print "key = ${e.key}, value =${e.value}"
                if("${e.value}" == "123"){
                    print "the key is ${e.key}"
                    
                }
            }
            //jsonResult.each{
              //  if(value == "123"){
               //     print key
               // }
           // } 
         //   echo "${jsonResult}"
            //def name = jsonResult.get("123")
            //echo "${jsonResult.keySet()}"
         //   echo "name is ${name}"
         //   echo "The port number is"
            //echo "${x}"
*/

        }
        stage('Second Stage'){
            echo "This is second stage"
        }
    }
}
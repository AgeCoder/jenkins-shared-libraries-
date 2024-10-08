def call(String Project, String ImageTag, String dockerhubuser) {
    withCredentials([usernamePassword(
        credentialsId: "dockerhubpass", 
        passwordVariable: "dockerHubPass", 
        usernameVariable: "dockerHubUser"
    )]) {
        sh "docker login -u ${dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker tag ${Project}:${ImageTag} ${dockerHubUser}/${Project}:${ImageTag}"
        sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}

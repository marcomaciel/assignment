// It is my Jenkinsfile test

pipeline{
    agent any

    environment {
        CONTAINER_ID = "${env.JOB_NAME}_${env.BUILD_ID}"
    }

   stages{
       stage('Get Source') { 
          steps {
             echo 'Container Id: ' + CONTAINER_ID
             git 'https://github.com/marcomaciel/assignment.git'
          }
       }
       stage('Build') {
           steps{
               sh "mvn -Dmaven.test.skip=true clean install"
           }
       }
       stage('Run Unit Tests') {
           steps{
               sh "mvn test"
           }
       }       
       stage('Create Dev Container') {
           steps {
                sh "docker run -d --rm -p 8889:8080 --name ${CONTAINER_ID} alpine/tomcat:1.0"
           }
       }
       stage('Deploy Dev') {
           steps {
            sh "docker cp target/assignment.war ${CONTAINER_ID}:/opt/tomcat/webapps/"
           }
       }
       stage('Test REST API') {
           steps {
               sh "newman run Assingnment-Java.postman_collection.json --reporters html,cli  --reporter-html-export newman/index.html "
           }
        }
    }
   
    post {
        always {
            echo '======> Post script'
            sh "docker rm -f ${CONTAINER_ID}"
        }
        success {
            echo '===> OK'
        }
        failure {
            echo '==============>>> Fail'
        }
    }
}


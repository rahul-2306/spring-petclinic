pipeline {
    agent{
        label "MAVEN"
    }
        options {
            timeout(time: 30, unit: 'MINUTES')
        }
    triggers { 
        pollSCM('* * * * *')
    }
    stages {
        stage('git') {
            steps {
                git url: 'https://github.com/rahul-2306/spring-petclinic.git', 
                    branch: 'spring-dev'
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
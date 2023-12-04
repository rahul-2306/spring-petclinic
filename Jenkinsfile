pipeline {
    agent{
        label "MAVEN"
    }
        options {
            timeout(time: 30, unit: 'MINUTES')
        }
    triggers { 
        cron('40 1 * * *')
    }
    stages {
        stage('git') {
            steps {
                git url: 'https://github.com/rahul-2306/spring-petclinic.git', 
                    branch: 'spring-release'
            }
        }
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
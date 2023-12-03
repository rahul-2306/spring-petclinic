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
            post {
                success {
                    archiveArtifacts artifacts: '**/spring-petclinic-*.jar'
                    junit testResults: '**/TEST-*.xml'
                    mail subject: 'build stage succeded',
                         from: 'build@lt.io',
                         to: 'rahul@lt.io',
                         body: 'Refer to $BUILD_URL for more detail'
                }
                failure {
                    mail subject: 'build stage failed',
                         from: 'build@learningthoughts.io',
                         to: 'all@learningthoughts.io',
                         body: 'Refer to $BUILD_URL for more details'
                }
            }
        }
    }
}
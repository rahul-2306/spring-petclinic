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
        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('sonar') {
                sh 'mvn clean package sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.organization=spring-23 -Dsonar.projectKey=spring-23'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time:30, unit: 'MINUTES'){
                waitForQualityGate abortPipeline: true
            }
        }
            post {
                success {
                    archiveArtifacts artifacts: '**/spring-petclinic-*.jar'
                    junit testResults: '**/TEST-*.xml'
                    mail subject: 'build stage succeded',
                         from: 'build@learningthoughts.io',
                         to: 'all@learningthoughts.io',
                         body: "Refer to $BUILD_URL for more details"
                }
                failure {
                    mail subject: 'build stage failed',
                         from: 'build@learningthoughts.io',
                         to: 'all@learningthoughts.io',
                         body: "Refer to $BUILD_URL for more details"
                }
            }
        }
        stage(){}           
    }
}
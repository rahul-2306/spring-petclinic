@Library('testlib') _

pipeline {
    agent any
    stages {
        stage('Example Stage') {
            steps {
                script {
                    test("clean package")
                }
            }
        }
    } 
}  
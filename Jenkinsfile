@Library('testlib') _

pipeline {
    agent any
    stages {
        sateg('Example Stage') {
            steps {
                script {
                    test("clean package")
                }
            }
        }
    } 
}  
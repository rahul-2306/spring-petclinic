@Library('common-dev')

pipeline {
    agent any
    stages {
        sateg('Example Stage') {
            steps {
                script {
                    test_maven("clean package")
                    def mylib = new dev.src.test_maven()
                    mylib.echo("clean package")
                }
            }
        }
    } 
}  
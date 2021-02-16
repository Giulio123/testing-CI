pipeline {
	agent any
	triggers {
        	pollSCM('* * * * *')
    	}
	stages {


		stage("Compile") {
			steps {
				sh "./gradlew compileJava"
			}
		}


		stage('Sonarqube') {
    environment {
        scannerHome = tool 'SonarQubeScanner'
    }
    steps {
        withSonarQubeEnv('sonarqube') {
             sh './gradlew sonarqube'
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }
   }
		
		stage("Unit test") {
			steps {
				sh "./gradlew test"
			}
		}
		stage("Code coverage") {
		    steps {
				sh "./gradlew jacocoTestReport"
				publishHTML (target: [
					allowMissing: false,
      				alwaysLinkToLastBuild: false,
      				keepAll: true,
					reportDir: 'build/reports/jacoco/test/html',
					reportFiles: 'index.html',
					reportName: "JaCoCo Report"
				])
				sh "./gradlew jacocoTestCoverageVerification"
		    }
		}
	}
}
node("nihao"){
   stage('Preparation') {
      git 'https://github.com/jglick/simple-maven-project-with-tests.git'
      mvnHome = tool "maven"
   }
   stage('Build') {
      bat("'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package")
   }
   stage('Results') {
      archive 'target/*.jar'
   }
}
node("nihao"){
   stage('Preparation') {
      git 'https://github.com/huchaogithup/springcloud.git'
      mvnHome = tool "maven"
   }
   stage('Build') {
      bat("${mvnHome}\\bin\\mvn -Dmaven.test.failure.ignore clean package")
   }
   stage('Results') {
      archive 'target/*.jar'
   }
}
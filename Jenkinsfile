node("nihao"){
   stage('Preparation') {
      git branch: 'develop', credentialsId: '79b9915e-69eb-41c1-9ee4-3dbf88d95ab5', url: 'https://github.com/huchaogithup/springcloud.git'
      mvnHome = tool "maven"
   }
   stage('Build') {
      bat("${mvnHome}\\bin\\mvn -Dmaven.test.failure.ignore clean package")
   }
   stage('Results') {
      archive 'target/*.jar'
   }
}
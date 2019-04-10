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
      def remote=[:]
      remote.host="172.27.25.190"
      remote.password="huawei-3com"
      remote.user="root"
      remote.allowAnyHosts = true
      remote.name = 'test'
      sshCommand remote:remote,command:"mkdir /docker"
   }
}
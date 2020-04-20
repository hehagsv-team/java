
@ECHO OFF
REM Keep the following attributes in standalone.xml(wildfly-10.0.0.Final\standalone\configuration\standalone.xml) at deployment-scanner element 
REM  <deployment-scanner path="deployments" relative-to="jboss.server.base.dir" scan-enabled="true" scan-interval="5000" auto-deploy-exploded="true" auto-deploy-zipped="true"  runtime-failure-causes-rollback="${jboss.deployment.scanner.rollback.on.failure:false}"/>
cd c:\
REM go to the directory where source and pom.xml present
cd \Users\Samsung\Documents\compile
call mvn package
cd c:\
REM go to the directory where you have wildfly server and inside that \standalone\deployments
cd \Softwares\wildfly-10.0.0.Final\standalone\deployments
mkdir wildfly-kitchensink-jsp.war
REM path where compiled target present. this is the path where pom.xml present and \target\wildfly-kitchensink-jsp
xcopy/S C:\Users\Samsung\Documents\compile\target\wildfly-kitchensink-jsp wildfly-kitchensink-jsp.war
cd c:\
standalone.bat
pause

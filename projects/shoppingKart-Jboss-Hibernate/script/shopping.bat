@ECHO OFF
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

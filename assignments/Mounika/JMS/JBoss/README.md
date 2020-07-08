
This project creates two JMS resources:

* A queue named `HELLOWORLDMDBQueue` bound in JNDI as `java:/queue/HELLOWORLDMDBQueue`
* A topic named `HELLOWORLDMDBTopic` bound in JNDI as `java:/topic/HELLOWORLDMDBTopic`


System requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 7 or later. 

All you need to build this project is Java 8.0 (Java SDK 1.8) or later and Maven 3.1.1 or later. See [Configure Maven for JBoss EAP 7](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN_JBOSS_EAP7.md#configure-maven-to-build-and-deploy-the-quickstarts) to make sure you are configured correctly for testing the quickstarts.


Use of EAP7_HOME
---------------

In the following instructions, replace `EAP7_HOME` with the actual path to your JBoss EAP installation. The installation path is described in detail here: [Use of EAP7_HOME and JBOSS_HOME Variables](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/USE_OF_EAP7_HOME.md#use-of-eap_home-and-jboss_home-variables).


Start the JBoss EAP Server with the Full Profile
---------------

1. Open a command prompt and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server with the full profile:

        For Linux:   EAP7_HOME/bin/standalone.sh -c standalone-full.xml
        For Windows: EAP7_HOME\bin\standalone.bat -c standalone-full.xml


Build and Deploy the Quickstart
-------------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. Type this command to build and deploy the archive:

        mvn clean install wildfly:deploy

4. This will deploy `target/jboss-helloworld-mdb.war` to the running instance of the server.

Access the application 
---------------------

The application will be running at the following URL: <http://localhost:8080/jboss-helloworld-mdb/> and will send some messages to the queue.

To send messages to the topic, use the following URL: <http://localhost:8080/jboss-helloworld-mdb/HelloWorldMDBServletClient?topic>

Undeploy the Archive
--------------------

1. Make sure you have started the JBoss EAP server as described above.
2. Open a command prompt and navigate to the root directory of this quickstart.
3. When you are finished testing, type this command to undeploy the archive:

        mvn wildfly:undeploy

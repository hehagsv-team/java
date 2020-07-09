Need to install JBOSS 5.0 
------------------------
   In Eclipse -- Servers-->New-->Server-->JbossCommunity-->JBOSS AS 5.0-->Next--->Next-->(there we can see Download and Install near Home directory) Click on it-->Finish

Add library
-----------
  To add this Jboss into this code, Right click on Project-->Properties-->Java BuildPath-->Add Library-->Server RunTime-->Select the server-->Finish.

Run the Project
---------------
  1. Run this JBOSS 5.0 from servers.
  2. Run TopicConsumer file as Java Application.(Run this as many Subscribers as you want)
  3. Run TopicProducer file as Java Application.
 
   Send message by entering in TopicProducer console and it can be seen in TopicConsumer console.
  

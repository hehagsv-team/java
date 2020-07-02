Dependents jar needed : javax.mail.jar
jar file find in below link:
https://javaee.github.io/javamail/
-------------------------------------------------------------
By using javaMail Api, we can send mails from java program
For that, javax.mail.jar file to be added
----------------------------------------------------------------------
Then we need to set some properties on java code like:

mail.smtp.auth --> defines weather authentication is needed for the email server
For example:
For Gmail, it is mandatory having a username and password to login
("mail.smtp.auth", "true");
 
mail.smtp.starttls.enable --> TLSAuthentication provides security for data communication 
over the internet
("mail.smtp.starttls.enable", "true");

mail.smtp.host : every mail server has a hostname
incase of gmail : ("mail.smtp.host", "smtp.gmail.com");

mail.smtp.port : every mail server has a port number
incase of gmail : ("mail.smtp.port", "587");
----------------------------------------------------------------------------------------------
Three steps to send email
1)Get the session Object
2)Compose the mail
3)send the mail
----------------------------------------------------------------------------------------------
1)Get the session Object
To get the session object, we have two methods provided by the javax.mail.Session class

Session.getDefaultInstance()
Session.getInstance()

Session session = Session.getDefaultInstance(properties,  
			    new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(myAccount,password);  
			      }  
			    });  
------------------------------------------------------------------------------------------------
2)Compose the mail
The javax.mail.Message class provides methods to compose the message.But it is an abstract class. 
so its subclass javax.mail.internet.MimeMessage class is mostly used.

Message message=new MimeMessage(session);  

Message message=new MimeMessage(session);  
message.setFrom(new InternetAddress("xxxxxxx@gmail.com"));  
message.addRecipient(Message.RecipientType.To,new InternetAddress("xxxxxxx@gmail.com"));  
message.setSubject("Welcome");  
message.setText("Hi, Glad to welcome......"); 
-----------------------------------------------------------------------------------------------
3)send the mail
javax.mail.Transport class send the message
Transport.send(message) 



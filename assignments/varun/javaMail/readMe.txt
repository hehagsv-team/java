Dependent jar needed : javax.mail.jar
jar file link:
https://javaee.github.io/javamail/
-------------------------------------------------------------
By using javaMail Api, we can send mails from java program
For that, javax.mail.jar file to be added
----------------------------------------------------------------------
It is need to set some properties on java code like:

mail.smtp.auth --> defines weather authentication is needed for the email server
For example:
For Gmail, it is mandatory having a username and password to login
("mail.smtp.auth", "true");
 
mail.smtp.starttls.enable --> TLSAuthentication provides security for data communication over the internet
("mail.smtp.starttls.enable", "true");

mail.smtp.host : every mail server has a hostname
Incase of gmail : ("mail.smtp.host", "smtp.gmail.com");

mail.smtp.port : every mail server has a port number
Incase of gmail : ("mail.smtp.port", "587");
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

Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {  
			      protected PasswordAuthentication getPasswordAuthentication() {  
			    return new PasswordAuthentication(senderMailAccount,password);  
			      }  
			    });  
------------------------------------------------------------------------------------------------
2)Compose the mail
The javax.mail.Message class provides methods to compose the message.But it is an abstract class. 
So its subclass javax.mail.internet.MimeMessage class is mostly used.

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

If code got below error:
javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted. Learn more at 535 5.7.8  https://support.google.com/mail/?p=BadCredentials r6sm7744879pfl.142 - gsmtp
Please turn on "Less secure app access" in senders mail account security settings 
Link for turning on "less secure app access" : https://myaccount.google.com/security 


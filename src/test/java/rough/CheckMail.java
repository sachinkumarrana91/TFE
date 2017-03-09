package rough;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CheckMail
{


	
	public static void check(String mailServer, String storeType ) throws MessagingException, AddressException, IOException
	//public static void sendMail(String mailServer, String from, String[] to, String subject, String messageBody, String attachmentPath, String attachmentName) throws MessagingException, AddressException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the username");
		final String username  = in.nextLine();
		System.out.println("Enter the password");
		final String password  = in.nextLine();
		
		Properties props = System.getProperties(); 
		props.put("mail.smtp.starttls.enable", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.host", mailServer); 
		props.put("mail.debug", "true");
//		Session session = Session.getDefaultInstance(props, null);


		Authenticator auth = new javax.mail.Authenticator(){
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		};
		
		
		Session session = Session.getDefaultInstance(props, auth);

		try
		{
			
/*			Transport bus = session.getTransport("smtp");
			bus.connect();
*/        
         //X-Priority values are generally numbers like 1 (for highest priority), 3 (normal) and 5 (lowest).
            
   
            
            Store store = session.getStore("pop3s");
            store.connect(mailServer, username, password);
            
            
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < 1; i++) {
               Message message = messages[i];
               System.out.println("---------------------------------");
               System.out.println("Email Number " + (i + 1));
               System.out.println("Subject: " + message.getSubject());
               System.out.println("From: " + message.getFrom()[0]);
               System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

            
         	 //bus.close();
    		
		}
		catch (MessagingException mex)
		{
            mex.printStackTrace();
        }		
	} 
	
	public static void main(String[] args) throws AddressException, MessagingException, IOException {

	      String host = "pop.gmail.com";// change accordingly
	      String mailStoreType = "pop3";
/*	      String username = "yourmail@gmail.com";// change accordingly
	      String password = "*****";// change accordingly
*/
	      check(host, mailStoreType);

	   }

}

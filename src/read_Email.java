/*  1:   */ import java.io.PrintStream;
/*  2:   */ import java.util.Properties;
/*  3:   */ import javax.mail.Address;
/*  4:   */ import javax.mail.BodyPart;
/*  5:   */ import javax.mail.Folder;
/*  6:   */ import javax.mail.Message;
/*  7:   */ import javax.mail.Multipart;
/*  8:   */ import javax.mail.Session;
/*  9:   */ import javax.mail.Store;
/* 10:   */ 
/* 11:   */ public class read_Email
/* 12:   */ {
/* 13:   */   public read_Email()
/* 14:   */   {
/* 15:18 */     Properties props = new Properties();
/* 16:19 */     props.setProperty("mail.store.protocol", "imaps");
/* 17:   */     try
/* 18:   */     {
/* 19:21 */       Session session = Session.getInstance(props, null);
/* 20:22 */       Store store = session.getStore();
/* 21:23 */       store.connect("imap.gmail.com", "yourEmailId@gmail.com", "password");
/* 22:24 */       Folder inbox = store.getFolder("INBOX");
/* 23:25 */       inbox.open(1);
/* 24:26 */       Message msg = inbox.getMessage(inbox.getMessageCount());
/* 25:27 */       Address[] in = msg.getFrom();
/* 26:28 */       for (Address address : in) {
/* 27:29 */         System.out.println("FROM:" + address.toString());
/* 28:   */       }
/* 29:31 */       Multipart mp = (Multipart)msg.getContent();
/* 30:32 */       BodyPart bp = mp.getBodyPart(0);
/* 31:33 */       System.out.println("SENT DATE:" + msg.getSentDate());
/* 32:34 */       System.out.println("SUBJECT:" + msg.getSubject());
/* 33:35 */       System.out.println("CONTENT:" + bp.getContent());
/* 34:   */     }
/* 35:   */     catch (Exception mex)
/* 36:   */     {
/* 37:37 */       mex.printStackTrace();
/* 38:   */     }
/* 39:   */   }
/* 40:   */ }


/* Location:           C:\Users\Bbaker13\Desktop\Program Projects\IBMDemoStandAlone.jar
 * Qualified Name:     read_Email
 * JD-Core Version:    0.7.0.1
 */
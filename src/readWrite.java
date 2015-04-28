/*   1:    */ import java.io.File;
/*   2:    */ import java.io.FileNotFoundException;
/*   3:    */ import java.io.FileWriter;
/*   4:    */ import java.io.IOException;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.util.Properties;
/*   7:    */ import java.util.Scanner;
/*   8:    */ import javax.mail.Authenticator;
/*   9:    */ import javax.mail.Message;
/*  10:    */ import javax.mail.Message.RecipientType;
/*  11:    */ import javax.mail.MessagingException;
/*  12:    */ import javax.mail.PasswordAuthentication;
/*  13:    */ import javax.mail.Session;
/*  14:    */ import javax.mail.Transport;
/*  15:    */ import javax.mail.internet.InternetAddress;
/*  16:    */ import javax.mail.internet.MimeMessage;
/*  17:    */ import javax.swing.JFileChooser;
/*  18:    */ import javax.swing.JOptionPane;
/*  19:    */ 
/*  20:    */ public class readWrite
/*  21:    */ {
/*  22:    */   public static String staffName;
/*  23:    */   public static String staffNumber;
/*  24:    */   
/*  25:    */   public readWrite(String input)
/*  26:    */   {
/*  27: 20 */     writeFile(input);
/*  28:    */   }
/*  29:    */   
/*  30:    */   public readWrite() {}
/*  31:    */   
/*  32:    */   public void chooseFile()
/*  33:    */   {
/*  34: 27 */     JFileChooser chooser = new JFileChooser();
/*  35: 28 */     Scanner lineScanner = null;
/*  36: 29 */     if (chooser.showOpenDialog(null) == 0)
/*  37:    */     {
/*  38: 30 */       File selectedFile = chooser.getSelectedFile();
/*  39: 31 */       Properties props = new Properties();
/*  40: 32 */       props.put("mail.smtp.auth", "true");
/*  41: 33 */       props.put("mail.smtp.starttls.enable", "true");
/*  42: 34 */       props.put("mail.smtp.host", "smtp.gmail.com");
/*  43: 35 */       props.put("mail.smtp.port", "587");
/*  44:    */       
/*  45: 37 */       Session session = Session.getInstance(props, 
/*  46: 38 */         new Authenticator()
/*  47:    */         {
/*  48:    */           protected PasswordAuthentication getPasswordAuthentication()
/*  49:    */           {
/*  50: 40 */             return new PasswordAuthentication(IBM_EmailApp.username, IBM_EmailApp.password);
/*  51:    */           }
/*  52:    */         });
/*  53:    */       try
/*  54:    */       {
/*  55:    */         try
/*  56:    */         {
/*  57: 46 */           lineScanner = new Scanner(selectedFile);
/*  58:    */         }
/*  59:    */         catch (FileNotFoundException e)
/*  60:    */         {
/*  61: 48 */           JOptionPane.showMessageDialog(null, "That file could not be found. Please try again");
/*  62: 49 */           e.printStackTrace();
/*  63:    */         }
/*  64: 51 */  
/*  65: 52 */         while (lineScanner.hasNextLine())
/*  66:    */         {
/*  67: 53 */           
/*  68: 54 */           String line = lineScanner.nextLine();
/*  69: 55 */           int i = 0;
/*  70: 56 */           
/*  71: 57 */           System.out.println(i);
/*  72:    */           try
/*  73:    */           {
/*  74: 59 */             while (!Character.isDigit(line.charAt(i)))
/*  75:    */             {
/*  76: 60 */               i++;
/*  77: 61 */               System.out.println(i);
/*  78:    */             }
/*  79:    */           }
/*  80:    */           catch (Exception e)
/*  81:    */           {
/*  82: 65 */             i++;
/*  83:    */           }
/*  84: 67 */           staffName = line.substring(0, i);
/*  85: 68 */           staffName = staffName.trim();
/*  86: 69 */           staffNumber = line.substring(i);
/*  87: 70 */           System.out.println(staffName);
/*  88: 71 */           System.out.println(staffNumber);
/*  89:    */           
/*  90:    */ 
/*  91: 74 */           Message message = new MimeMessage(session);
/*  92: 75 */           message.setFrom(new InternetAddress("Java"));
/*  93: 76 */           message.setRecipients(Message.RecipientType.TO, 
/*  94: 77 */             InternetAddress.parse(staffNumber));
/*  95: 78 */           message.setSubject("Notification from Java for " + staffName);
/*  96: 79 */           message.setText(choiceMenu.messageToSend);
/*  97:    */           
/*  98: 81 */           Transport.send(message);
/*  99:    */           
/* 100:    */ 
/* 101: 84 */           System.out.println("Done");
/* 102:    */         }
/* 103:    */       }
/* 104:    */       catch (MessagingException e)
/* 105:    */       {
/* 106: 88 */         JOptionPane.showMessageDialog(null, "There was an error. Please ensure you entered your username and email correctly. If the problem persists, please seek technical support. Thank you");
/* 107: 89 */         throw new RuntimeException(e);
/* 108:    */       }
/* 109:    */     }
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void writeFile(String write)
/* 113:    */   {
/* 114:104 */     JFileChooser chooser = new JFileChooser();
/* 115:105 */     if (chooser.showOpenDialog(null) == 0)
/* 116:    */     {
/* 117:106 */       File selectedFile = chooser.getSelectedFile();
/* 118:107 */       System.getProperty("line.separator");
/* 119:    */       try
/* 120:    */       {
/* 121:109 */         FileWriter out = new FileWriter(selectedFile, true);
/* 122:110 */         if (!write.matches(".*\\d.*"))
/* 123:    */         {
/* 124:111 */           out.write(System.getProperty("line.separator"));
/* 125:112 */           out.write(write + " ");
/* 126:113 */           out.close();
/* 127:    */         }
/* 128:    */         else
/* 129:    */         {
/* 130:115 */           out.write(write);
/* 131:116 */           out.close();
/* 132:    */         }
/* 133:    */       }
/* 134:    */       catch (IOException e)
/* 135:    */       {
/* 136:119 */         JOptionPane.showMessageDialog(null, "That file could not be found. Please try again");
/* 137:120 */         e.printStackTrace();
/* 138:    */       }
/* 139:    */     }
/* 140:    */   }
/* 141:    */ }


/* Location:           C:\Users\Bbaker13\Desktop\Program Projects\IBMDemoStandAlone.jar
 * Qualified Name:     readWrite
 * JD-Core Version:    0.7.0.1
 */
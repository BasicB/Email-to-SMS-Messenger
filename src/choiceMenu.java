/*  1:   */ import java.awt.Desktop;
/*  2:   */ import java.awt.event.ActionEvent;
/*  3:   */ import java.awt.event.ActionListener;
/*  4:   */ import java.io.IOException;
/*  5:   */ import java.net.URI;
/*  6:   */ import java.net.URISyntaxException;
/*  7:   */ import javax.swing.JButton;
/*  8:   */ import javax.swing.JFrame;
/*  9:   */ import javax.swing.JOptionPane;
/* 10:   */ import javax.swing.JPanel;
/* 11:   */ 
/* 12:   */ public class choiceMenu
/* 13:   */   extends JFrame
/* 14:   */ {
/* 15:   */   private static final long serialVersionUID = 1L;
/* 16:   */   public static String messageToSend;
/* 17:   */   private static final int FRAME_WIDTH = 800;
/* 18:   */   private static final int FRAME_HEIGHT = 400;
/* 19:   */   private JPanel panel;
/* 20:   */   private JButton addNumbutton;
/* 21:   */   private JButton sendMsgbutton;
/* 22:   */   private JButton carriersbutton;
/* 23:   */   
/* 24:   */   public choiceMenu()
/* 25:   */   {
/* 26:28 */     createButtons();
/* 27:29 */     createPanel();
/* 28:30 */     setSize(800, 400);
/* 29:   */   }
/* 30:   */   
/* 31:   */   private void createPanel()
/* 32:   */   {
/* 33:34 */     this.panel = new JPanel();
/* 34:35 */     this.panel.add(this.addNumbutton);
/* 35:36 */     this.panel.add(this.sendMsgbutton);
/* 36:37 */     this.panel.add(this.carriersbutton);
/* 37:38 */     add(this.panel);
/* 38:   */   }
/* 39:   */   
/* 40:   */   private void createButtons()
/* 41:   */   {
/* 42:42 */     this.addNumbutton = new JButton("Add number");
/* 43:43 */     this.sendMsgbutton = new JButton("Send Message");
/* 44:44 */     this.carriersbutton = new JButton("See Carriers");
/* 45:   */     
/* 46:46 */     ActionListener addlistener = new choiceMenu.addNumListener();
/* 47:47 */     this.addNumbutton.addActionListener(addlistener);
/* 48:   */     
/* 49:49 */     ActionListener sendlistener = new choiceMenu.sendMsgListener();
/* 50:50 */     this.sendMsgbutton.addActionListener(sendlistener);
/* 51:   */     
/* 52:52 */     ActionListener carrierlistener = new choiceMenu.carriershowListener();
/* 53:53 */     this.carriersbutton.addActionListener(carrierlistener);
/* 54:   */   }
/* 55:   */   
/* 56:   */   class addNumListener
/* 57:   */     implements ActionListener
/* 58:   */   {
/* 59:   */     addNumListener() {}
/* 60:   */     
/* 61:   */     public void actionPerformed(ActionEvent event)
/* 62:   */     {
/* 63:60 */       prompt_GUI addName = new prompt_GUI("Type in the staff's name:> ");
/* 64:61 */       String staffinfo = addName.input;
/* 65:62 */       readWrite staffAddName = new readWrite(staffinfo);
/* 66:63 */       staffinfo = JOptionPane.showInputDialog("Please enter the staff's phone number with correct ending.");
/* 67:64 */       staffAddName.writeFile(staffinfo);
/* 68:   */     }
/* 69:   */   }
/* 70:   */   
/* 71:   */   class sendMsgListener
/* 72:   */     implements ActionListener
/* 73:   */   {
/* 74:   */     sendMsgListener() {}
/* 75:   */     
/* 76:   */     public void actionPerformed(ActionEvent event)
/* 77:   */     {
/* 78:70 */       prompt_GUI sendMessage = new prompt_GUI("Enter your message:> ");
/* 79:71 */       choiceMenu.messageToSend = sendMessage.input;
/* 80:72 */       readWrite justSending = new readWrite();
/* 81:73 */       justSending.chooseFile();
/* 82:   */     }
/* 83:   */   }
/* 84:   */   
/* 85:   */   class carriershowListener
/* 86:   */     implements ActionListener
/* 87:   */   {
/* 88:   */     carriershowListener() {}
/* 89:   */     
/* 90:   */     public void actionPerformed(ActionEvent event)
/* 91:   */     {
/* 92:   */       try
/* 93:   */       {
/* 94:81 */         URI domain = new URI("http://martinfitzpatrick.name/list-of-email-to-sms-gateways/");
/* 95:82 */         Desktop.getDesktop().browse(domain);
/* 96:   */       }
/* 97:   */       catch (URISyntaxException|IOException e)
/* 98:   */       {
/* 99:84 */         JOptionPane.showMessageDialog(null, "The URL could not be found.");
/* :0:85 */         e.printStackTrace();
/* :1:   */       }
/* :2:   */     }
/* :3:   */   }
/* :4:   */ }


/* Location:           C:\Users\Bbaker13\Desktop\Program Projects\IBMDemoStandAlone.jar
 * Qualified Name:     choiceMenu
 * JD-Core Version:    0.7.0.1
 */
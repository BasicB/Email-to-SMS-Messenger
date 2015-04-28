/*  1:   */ import javax.swing.JFrame;
/*  2:   */ 
/*  3:   */ public class IBM_EmailApp
/*  4:   */ {
/*  5:   */   public static String username;
/*  6:   */   public static String password;
/*  7:   */   
/*  8:   */   public static void main(String[] args)
/*  9:   */   {
/* 10:12 */     prompt_GUI emailUN = new prompt_GUI("Please enter your username for GMAIL");
/* 11:13 */     username = emailUN.input;
/* 12:14 */     prompt_GUI emailPW = new prompt_GUI("Please enter your password for GMAIL");
/* 13:15 */     password = emailPW.input;
/* 14:16 */     JFrame frame = new choiceMenu();
/* 15:17 */     frame.setDefaultCloseOperation(3);
/* 16:18 */     frame.setVisible(true);
/* 17:   */   }
/* 18:   */ }


/* Location:           C:\Users\Bbaker13\Desktop\Program Projects\IBMDemoStandAlone.jar
 * Qualified Name:     IBM_EmailApp
 * JD-Core Version:    0.7.0.1
 */
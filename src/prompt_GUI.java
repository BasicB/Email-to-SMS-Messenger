import javax.swing.JOptionPane;


public class prompt_GUI {
	public String input;
	
	public prompt_GUI(String toDisplay) {
		input = JOptionPane.showInputDialog(toDisplay);
	}
	
	
}

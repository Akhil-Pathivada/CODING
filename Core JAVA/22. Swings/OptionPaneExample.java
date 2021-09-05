import java.awt.event.*;
import javax.swing.*;
class OptionPaneExample
{
	OptionPaneExample()
	{
		JFrame f=new JFrame("A simple Option Panel");
		JOptionPane.showMessageDialog(f,"Hello....Welcome");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new OptionPaneExample();
	}
}
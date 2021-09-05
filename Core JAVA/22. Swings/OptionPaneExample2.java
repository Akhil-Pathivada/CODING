import javax.swing.*;  
public class OptionPaneExample2 
{  
	JFrame f;  
	OptionPaneExample2()
	{  
		f=new JFrame();  
		JOptionPane.showMessageDialog(f,"Successfully Updated.","Alert",JOptionPane.WARNING_MESSAGE);     
	}  
	public static void main(String[] args) 
	{  
		new OptionPaneExample2();  
	}  
}  
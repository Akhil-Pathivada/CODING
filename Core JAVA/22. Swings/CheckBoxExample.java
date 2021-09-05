import java.awt.event.*;
import javax.swing.*;
class CheckBoxExample implements ItemListener
{
	JCheckBox cb1,cb2;
	JLabel label;
	CheckBoxExample()
	{
		JFrame f=new JFrame("CheckBox Example");
		cb1=new JCheckBox("C++");
		cb2=new JCheckBox("Java");
		cb1.setBounds(150,100,50,50);
		cb2.setBounds(150,150,50,50);
		label.setSize(400,100);
		f.add(cb1);
		f.add(cb2);
		f.add(label);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange()==1 && e.getSource()==cb1) 
		{
			label.setText("C++ box checked....");
		}
		else if(e.getStateChange()==1 && e.getSource()==cb2) 
		{
			label.setText("Java box checked....");
		}
	}
	public static void main(String args[])
	{
		new CheckBoxExample();
	}
}
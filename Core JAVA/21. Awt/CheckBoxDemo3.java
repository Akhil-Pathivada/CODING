//same as previous example
import java.awt.*;
import java.awt.event.*;
class CheckBoxDemo3 extends Frame implements ItemListener
{
	Checkbox cb1,cb2;
	Label label;
	CheckBoxDemo3()
	{
		cb1=new Checkbox("C++");
		cb2=new Checkbox("Java");
		cb1.setBounds(100,100,50,50);
		cb2.setBounds(100,150,50,50);
		label=new Label();
		label.setSize(500,100);
		setSize(400,400);
		add(cb1);
		add(cb2);
		add(label);
		setLayout(null);
		setVisible(true);
		cb1.addItemListener(this);
		cb2.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange()==1 && e.getSource()==cb1) label.setText("C++ checkbox is checked");
		if(e.getStateChange()==1 && e.getSource()==cb2) label.setText("Java checkbox is checked");
	}
	public static void main(String args[])
	{
		new CheckBoxDemo3();
	}
}
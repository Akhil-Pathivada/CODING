// creating simple checkboxes
import java.awt.*;
import java.awt.event.*;
class CheckBoxDemo
{
	CheckBoxDemo()
	{
		Frame f=new Frame("CheckBox Example");
		f.setSize(400,400);
		Checkbox cb1=new Checkbox("C++"); // by default it is 'false'
		Checkbox cb2=new Checkbox("Java",true); // making it as 'true'
		cb1.setBounds(100,100,50,50);
		cb2.setBounds(100,150,50,50);
		f.add(cb1);
		f.add(cb2);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new CheckBoxDemo();
	}
}
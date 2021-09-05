//CheckboxGroup Example
import java.awt.*;
import java.awt.event.*;
class CheckboxGroupDemo
{
	CheckboxGroupDemo()
	{
		Frame f=new Frame("CheckboxGroup Example");
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox cb1=new Checkbox("C++",cbg,false);
		Checkbox cb2=new Checkbox("Java",cbg,true);
		cb1.setBounds(100,100,50,50);
		cb2.setBounds(100,150,50,50);
		f.add(cb1);
		f.add(cb2);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new CheckboxGroupDemo();
	}
}
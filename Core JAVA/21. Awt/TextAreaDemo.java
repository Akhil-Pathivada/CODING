import java.awt.*;
import java.awt.event.*;
class TextAreaDemo
{
	TextAreaDemo()
	{
		Frame f=new Frame("TextArea example");
		TextArea ta=new TextArea("Welcome to JavaTpoint");
		ta.setBounds(10,30,300,300);
		f.add(ta);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public static void main(String args[])
	{
		new TextAreaDemo();
	}
}
import java.awt.*;
import java.awt.event.*;
class LabelDemo
{
	LabelDemo()
	{
		Frame f=new Frame("Label Example");
		Label l1,l2;
		l1=new Label("This is first label");
		l1.setBounds(50,100,100,30);
		l2=new Label("This is second label");
		l2.setBounds(50,150,120,30);
		f.add(l1);
		f.add(l2);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new LabelDemo();
	}
}
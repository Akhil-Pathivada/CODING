//Java event handling by outer class
import java.awt.*;
import java.awt.event.*;
class EventHandlingDemo2 extends Frame
{
	TextField tf;
	EventHandlingDemo2()
	{
		tf=new TextField();
		tf.setBounds(60,50,200,50);
		Button b=new Button("Please Click me");
		b.setBounds(100,120,80,30);
		Outer o=new Outer(this);
		b.addActionListener(o);
		add(b);
		add(tf);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new EventHandlingDemo2();
	}
}
class Outer implements ActionListener
{
	EventHandlingDemo2 obj;
	Outer(EventHandlingDemo2 obj)
	{
		this.obj=obj;
	}
	public void actionPerformed(ActionEvent e)
	{
		obj.tf.setText("Hi! Everyone");
	}
}
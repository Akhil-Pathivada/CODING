// EventHandling through Anonymous class
import java.awt.*;
import java.awt.event.*;
class EventHandlingDemo3 extends Frame
{
	TextField tf;
	EventHandlingDemo3()
	{
		tf=new TextField();
		tf.setBounds(60,50,170,25);
		Button b=new Button("Click me");
		b.setBounds(50,120,80,30);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("Hi! Guys");
			}
		}
		);
		add(b);
		add(tf);
		setSize(300,400);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new EventHandlingDemo3();
	}
}
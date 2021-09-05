import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class EventHandling extends Applet implements ActionListener
{
	TextField tf;
	Button b;
	public void init()
	{
		tf=new TextField();
		tf.setBounds(30,40,150,20);
		b=new Button("Click me");
		b.setBounds(80,150,60,50);
		b.addActionListener(this);
		setLayout(null);
		add(b);
		add(tf);
	}
	public void actionPerformed(ActionEvent e)
	{
		tf.setText("Hi Everyone.....");
	}
}
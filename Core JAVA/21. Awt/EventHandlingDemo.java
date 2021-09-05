//changing the state of an object is known as 'Event'
//Java event handling by implementing ActionListener
import java.awt.*;
import java.awt.event.*;
class EventHandlingDemo extends Frame implements ActionListener
{
	TextField tf;
	EventHandlingDemo()
	{
		tf=new TextField();
		tf.setBounds(60,50,170,20);
		Button b= new Button("Click me");
		b.setBounds(100,120,80,30);
		b.addActionListener(this);
		add(b);//adding button into the frame 
		add(tf);//adding text field into the frame
		setSize(300,300);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		tf.setText("Welcome");
	}
	public static void main(String args[])
	{
		new EventHandlingDemo();
	}
}
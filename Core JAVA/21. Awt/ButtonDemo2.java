//Button Example with ActionListener
import java.awt.*;
import java.awt.event.*;
class ButtonDemo2
{
	ButtonDemo2()
	{
		Frame f=new Frame("Buutton Example");
		TextField tf=new TextField();
		tf.setBounds(50,60,70,20);
		Button b=new Button("Click me");
		f.add(b);
		f.add(tf);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("Hi....Akhil");
			}
		});
		b.setBounds(50,100,60,30);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new ButtonDemo2();
	}
}
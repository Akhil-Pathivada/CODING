//label example with Action Listener
import java.awt.*;
import java.awt.event.*;
public class LabelDemo2
{
	LabelDemo2()
	{
		Frame f=new Frame("Label Example");
		f.setSize(500,500);
		TextField tf=new TextField();
		tf.setBounds(20,100,210,25);
		Label l=new Label();
		l.setBounds(20,150,250,20);
		Button b=new Button("Please Click me");
		b.setBounds(50,200,160,30);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				l.setText("Welcome to JavaTpoint");
				tf.setText("Welcome to Programming World");
			}
		});
		f.add(b);
		f.add(l);
		f.add(tf);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new LabelDemo2();
	}
}
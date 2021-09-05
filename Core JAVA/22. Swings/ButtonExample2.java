//JButton Example with ActionListener
import java.awt.event.*;
import javax.swing.*;
class ButtonExample2
{
	ButtonExample2()
	{
		JFrame f=new JFrame("Button Example");
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b=new JButton("Click me");
		b.setBounds(50,100,95,30);
		JTextField tf=new JTextField();
		tf.setBounds(50,50,150,20);
		f.add(tf);
		f.add(b);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tf.setText("Welcome to JavaTpoint");
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new ButtonExample2();
	}
}
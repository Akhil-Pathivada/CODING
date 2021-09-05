//Example of displaying image on the button:
import javax.swing.*;
import java.awt.event.*;
class ButtonExample3
{
	ButtonExample3()
	{
		JFrame f=new JFrame("Button Example");
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b=new JButton(new ImageIcon("register.jpg"));
		b.setBounds(50,100,145,70);
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
		new ButtonExample3();
	}
}
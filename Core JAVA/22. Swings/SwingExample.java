//Swing by Association inside constructor
import javax.swing.*;
class SwingExample
{
	SwingExample()
	{
		JFrame f=new JFrame("Swing Example");
		JButton b=new JButton("Click me");
		b.setBounds(130,100,100,40);
		f.add(b);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new SwingExample();
	}
}
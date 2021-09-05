//Simple example of Swing by inheritance
import javax.swing.*;
class SwingExample2 extends JFrame
{
	//JFrame f;
	SwingExample2()
	{
		JButton b=new JButton("Click me");
		b.setBounds(130,100,100,40);
		add(b);
		setLayout(null);
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new SwingExample2();
	}
}
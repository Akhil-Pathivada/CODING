import java.awt.*;
import javax.swing.*;
class BorderLayoutDemo2 extends JFrame
{
	BorderLayoutDemo2()
	{
		//JFrame f=new JFrame("BorderLayout");
		JLabel l1=new JLabel("North");
		JLabel l2=new JLabel("West");
		JLabel l3=new JLabel("East");
		JLabel l4=new JLabel("South");
		JLabel l5=new JLabel("Center");
		add(l1,BorderLayout.NORTH);
		add(l2,BorderLayout.WEST);
		add(l3,BorderLayout.EAST);
		add(l4,BorderLayout.SOUTH);
		add(l5,BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new BorderLayoutDemo2();
	}
}
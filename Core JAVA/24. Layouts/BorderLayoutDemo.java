import javax.swing.*;
import java.awt.*;
public class BorderLayoutDemo
{
	BorderLayoutDemo()
	{
		JFrame f=new JFrame("Border Layout");
		JButton b1=new JButton("North");
		JButton b2=new JButton("South");
		JButton b3=new JButton("East");
		JButton b4=new JButton("West");
		JButton b5=new JButton("Center");
		f.add(b1,BorderLayout.NORTH);
		f.add(b2,BorderLayout.SOUTH);
		f.add(b3,BorderLayout.EAST);
		f.add(b4,BorderLayout.WEST);
		f.add(b5,BorderLayout.CENTER);
		f.setSize(400,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new BorderLayoutDemo();
	}
}
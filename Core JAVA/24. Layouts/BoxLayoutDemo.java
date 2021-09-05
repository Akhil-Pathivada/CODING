import java.awt.*;
import javax.swing.*;
class BoxLayoutDemo
{
	BoxLayoutDemo()
	{
		JFrame f=new JFrame("BoxLayout");
		JButton buttons[]=new JButton[5];
		for(int i=0;i<5;i++)
		{
			buttons[i]=new JButton("Button"+(i+1));
			f.add(buttons[i]);
		}
		BoxLayout boxLayout = new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS);
		f.setLayout(boxLayout);
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new BoxLayoutDemo();
	}
}
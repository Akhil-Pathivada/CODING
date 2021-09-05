import javax.swing.*;
import java.awt.*;
class LayeredPaneExample extends JFrame
{
	LayeredPaneExample()
	{
		super("LayeredPane Example");
		setSize(400,400);
		setVisible(true);
		JLayeredPane pane=getLayeredPane();
		//creating buttons
		JButton top=new JButton();
		JButton middle=new JButton();
		JButton bottom=new JButton();
		top.setBackground(Color.white);
		middle.setBackground(Color.red);
		bottom.setBackground(Color.cyan);
		top.setBounds(20,20,100,100);
		middle.setBounds(40,40,100,100);
		bottom.setBounds(60,60,100,100);
		pane.add(top,new Integer(1));
		pane.add(middle,new Integer(2));
		pane.add(bottom,new Integer(3));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new LayeredPaneExample();
	}
}
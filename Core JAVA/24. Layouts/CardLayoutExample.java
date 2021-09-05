import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class CardLayoutExample extends JFrame implements ActionListener
{
	CardLayout card;
	Container c;
	CardLayoutExample()
	{
		c=getContentPane();
		JButton b1=new JButton("Button 1");
		JButton b2=new JButton("Button 2");
		JButton b3=new JButton("Button 3");
		card=new CardLayout(40,30);
		c.setLayout(card);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setSize(400,400);
	}
	public void actionPerformed(ActionEvent e)
	{
		card.next(c);
	}
	public static void main(String args[])
	{
		new CardLayoutExample();
	}
}
import java.awt.event.*;
import javax.swing.*;
class RadioButtonDemo extends JFrame implements ActionListener
{
	JButton b;
	JRadioButton rb1,rb2;
	RadioButtonDemo()
	{
		b=new JButton("select");
		b.setBounds(100,150,80,30);
		rb1=new JRadioButton("Male");
		rb1.setBounds(100,50,100,30);
		rb2=new JRadioButton("Female");
		rb2.setBounds(100,100,100,30);
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);bg.add(rb2);
		add(rb1);add(rb2);
		add(b);
		setVisible(true);
		setLayout(null);
		setSize(400,400);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(rb1.isSelected())
			JOptionPane.showMessageDialog(this,"You are Male");
		if(rb2.isSelected())
			JOptionPane.showMessageDialog(this,"You are Female");
	}
	public static void main(String args[])
	{
		new RadioButtonDemo();
	}
}
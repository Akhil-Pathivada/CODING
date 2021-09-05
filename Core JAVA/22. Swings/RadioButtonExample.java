import java.awt.event.*;
import javax.swing.*;
class RadioButtonExample extends JFrame implements ActionListener
{
	JLabel label;
	JRadioButton rb1,rb2;
	JButton b;
	RadioButtonExample()
	{
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");
		rb1.setBounds(100,50,100,30);
		rb2.setBounds(100,100,100,30);
		b=new JButton("Ok");
		b.setBounds(100,150,80,30);
		add(rb1);
		add(rb2);
		add(b);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(rb1.isSelected())
		{
			JOptionPane.showMessageDialog(this,"You are Male");
		}
		if(rb2.isSelected())
		{
			JOptionPane.showMessageDialog(this,"You are Female");
		}
	}
	public static void main(String args[])
	{
		new RadioButtonExample();
	}
}
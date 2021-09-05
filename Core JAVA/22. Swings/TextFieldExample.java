import java.awt.event.*;
import javax.swing.*;
class TextFieldExample implements ActionListener
{
	JTextField tf1,tf2,tf3;
	JButton b1,b2;
	TextFieldExample()
	{
		JFrame f=new JFrame("TextField Example");
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf1.setBounds(50,50,150,20); 
		tf2.setBounds(50,100,150,20);  
		tf3.setBounds(50,150,150,20);  
		b1=new JButton("+");
		b2=new JButton("-");
		b1.setBounds(50,200,50,50);
		b2.setBounds(120,200,50,50);
		f.add(b1);
		f.add(b2);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e )
	{
		String s1=tf1.getText();
		String s2=tf2.getText();
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		int c=0;
		if(e.getSource()==b1) 
		{
			c=a+b;
		}
		else if(e.getSource()==b2)
		{
			 c=a-b;
		}
		String result=String.valueOf(c);  
		tf3.setText(result);
	}
	public static void main(String args[])
	{
		new TextFieldExample();
	}
}
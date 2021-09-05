import java.awt.event.*;
import javax.swing.*;
class PasswordFieldExample 
{
	PasswordFieldExample()
	{
		JFrame f=new JFrame("Creditnals");
		JButton b=new JButton("View details");
		b.setBounds(100,120,80,30);
		JTextField tf1=new JTextField();
		tf1.setBounds(100,20,100,30);
		JLabel username=new JLabel("UserName : ");
		username.setBounds(20,20,80,30);
		JLabel password=new JLabel("Password : ");
		password.setBounds(20,75,80,30);
		JPasswordField value = new JPasswordField();   
		value.setBounds(100,75,100,30); 
		f.setSize(500,500);
		JLabel label=new JLabel();
		label.setBounds(20,150,400,50);
		f.setLayout(null);
		f.setVisible(true);
			f.add(b);f.add(username);f.add(password);
		f.add(value);f.add(tf1);f.add(label);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e )
			{
				String data="username : "+tf1.getText();
				data+=",password :" + new String(value.getPassword());
				label.setText(data);
			}
		});
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new PasswordFieldExample();
	}
}
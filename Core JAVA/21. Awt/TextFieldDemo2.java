//a simple calculator
import java.awt.*;
import java.awt.event.*;
class TextFieldDemo2
{
	TextFieldDemo2()
	{
		Frame f=new Frame("Caluclator");
		TextField tf1,tf2,tf3;
		tf1=new TextField("10");  
        tf1.setBounds(50,50,150,20);  
        tf2=new TextField("5");  
        tf2.setBounds(50,100,150,20);  
        tf3=new TextField();  
        tf3.setBounds(50,150,150,20);  
		Button b1,b2;
		b1=new Button("+");
		b1.setBounds(50,200,50,50);
		b2=new Button("-");
		b2.setBounds(150,200,50,50);
		f.setSize(400,400);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(b1);
		f.add(b2);
		f.setLayout(null);
		f.setVisible(true);
		//getting strings from the TextFields
		String s1=tf1.getText();
		String s2=tf2.getText();
		//converting strings into integers
		int a=Integer.parseInt(s1);
		int b=Integer.parseInt(s2);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int c=a+b;
				String Result=String.valueOf(c);
				tf3.setText(Result);
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int c=a-b;
				String Result=String.valueOf(c);
				tf3.setText(Result);
				
			}
		});
		
	}
	public static void main(String args[])
	{
		new TextFieldDemo2();
	}
}
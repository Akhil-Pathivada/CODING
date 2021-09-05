//Choice example with ActionListener
import java.awt.*;
import java.awt.event.*;
class ChoiceExample2
{
	ChoiceExample2()
	{
		Frame f=new Frame("Choice Example");
		Choice c=new Choice();
		c.add("C");
		c.add("C++");
		c.add("Java");
		c.add("Python");
		c.add("Ruby");
		f.add(c);
		f.setSize(500,500);
		c.setBounds(100,100,75,75);
		Button b=new Button("show");
		b.setBounds(200,100,50,20);
		f.add(b);
		Label label=new Label();
		label.setSize(400,120);
		f.add(label);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String s="Programming Language selected is : "+c.getItem(c.getSelectedIndex());
				label.setText(s);
			}
		}
		);
	}
	public static void main(String args[])
	{
		new ChoiceExample2();
	}
	
}
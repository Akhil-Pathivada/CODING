import javax.swing.*;
import java.awt.event.*;
class LabelExample
{
	LabelExample()
	{
		JFrame f=new JFrame("Label Example");
		JLabel label;
		label=new JLabel("First Label");
		label.setBounds(50,50,100,30);
		JButton b=new JButton();
		b.setBounds(50,150,95,30);
		f.add(b);
		f.setSize(400,400);
		f.add(label);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				label.setText("Hi...Akhil Pathivada");
			}
		});
	}
	public static void main(String args[])
	{
		new LabelExample();
	}
}
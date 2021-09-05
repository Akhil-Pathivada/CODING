//TextArea Example with ActionListener
import java.awt.*;
import java.awt.event.*;
class TextAreaDemo2
{
	TextAreaDemo2()
	{
		Frame f=new Frame("TextArea Example");
		String s="this is akhil pathivada";
		TextArea ta=new TextArea(s);
		ta.setBounds(20,100,300,300);
		Label l1,l2;
		l1=new Label();
		l1.setBounds(50,50,100,30);
		l2=new Label();
		l2.setBounds(160,50,100,30);
		Button b=new Button("Count words");
		b.setBounds(100,400,100,30);
		f.setSize(500,500);
		f.add(l1);
		f.add(l2);
		f.add(b);
		f.add(ta);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String words[]=s.split("\\s");
				l1.setText("Words : "+words.length);
				l2.setText("Characters : "+s.length());
			}
		});
	}
	public static void main(String args[])
	{
		new TextAreaDemo2();
	}
}
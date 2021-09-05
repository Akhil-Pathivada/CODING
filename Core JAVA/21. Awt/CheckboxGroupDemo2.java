//CheckboxGroup Example with ItemListener
import java.awt.*;
import java.awt.event.*;
class CheckboxGroupDemo2
{
	CheckboxGroupDemo2()
	{
		Frame f=new Frame("CheckboxGroup Example");
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox cb1=new Checkbox("C++",cbg,false);
		Checkbox cb2=new Checkbox("Java",cbg,false);
		cb1.setBounds(100,100,50,50);
		cb2.setBounds(100,150,50,50);
		Label label=new Label();
		label.setSize(500,130);
		f.add(cb1);
		f.add(cb2);
		f.add(label);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		cb1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				label.setText("C++ checkbox : checked");
			}
		});
		cb2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e) 
			{
				label.setText("Java checkbox : checked");
			}
		});
	}
	public static void main(String args[])
	{
		new CheckboxGroupDemo2();
	}
}
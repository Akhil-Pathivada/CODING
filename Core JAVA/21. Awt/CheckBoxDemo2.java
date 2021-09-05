//AWT Checkbox Example with ItemListener
import java.awt.*;
import java.awt.event.*;
class CheckBoxDemo2
{
	CheckBoxDemo2()
	{
		Frame f=new Frame("CheckBox Example");
		Checkbox cb1=new Checkbox("C++");
		Checkbox cb2=new Checkbox("Java");
		cb1.setBounds(100,100,50,50);
		cb2.setBounds(100,150,50,50);
		Label label=new Label();
		label.setSize(400,10);
		f.add(cb1);
		f.add(cb2);
		f.add(label);
		f.setSize(400,400);
		f.setVisible(true);
		f.setLayout(null);
		cb1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				label.setText("C++ checkbox :"+(e.getStateChange()==1?"checked":"unchecked"));
			}
		});
		cb2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				label.setText("Java checkbox :"+(e.getStateChange()==1?"checked":"unchecked"));
			}
		});
	}
	public static void main(String args[])
	{
		new CheckBoxDemo2();
	}
}
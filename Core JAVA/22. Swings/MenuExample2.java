import javax.swing.*;
import java.awt.event.*;
class MenuExample2
{
	MenuExample2()
	{
		JFrame f=new JFrame("Notepad++");
		JMenu file,edit,settings,help;
		file=new JMenu("File");
		edit=new JMenu("Edit");
		help=new JMenu("Help");
		settings=new JMenu("Settings");
		JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9;
		i1=new JMenuItem("item1");
		i2=new JMenuItem("item2");
		i3=new JMenuItem("item3");
		i4=new JMenuItem("item4");
		i5=new JMenuItem("item5");
		i6=new JMenuItem("item6");
		i7=new JMenuItem("item7");
		i8=new JMenuItem("item8");
		i9=new JMenuItem("item9");
		file.add(i1);
		file.add(i2);
		file.add(i3);
		edit.add(i4);
		edit.add(i5);
		edit.add(i6);
		help.add(i7);
		help.add(i8);
		help.add(i9);
		JMenuBar mb=new JMenuBar();
		mb.add(file);
		mb.add(edit);
		mb.add(settings);
		mb.add(help);
		f.setJMenuBar(mb);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new MenuExample2();
	}
}
import javax.swing.*;
import java.awt.event.*;
class MenuExample
{
	MenuExample()
	{
		JFrame f=new JFrame("Simple Menu ");
		JMenu menu =new JMenu("Menu");
		JMenuItem i1,i2,i3,i4,i5;
		i1=new JMenuItem("item1");
		i2=new JMenuItem("item2");
		i3=new JMenuItem("item3");
		i4=new JMenuItem("item4");
		i5=new JMenuItem("item5");
		JMenu submenu=new JMenu("submenu");
		submenu.add(i4);
		submenu.add(i5);
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		menu.add(submenu);
		JMenuBar mb=new JMenuBar();
		mb.add(menu);
		f.setJMenuBar(mb);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new MenuExample();
	}
}
// a simple MenuItem and Menu Example
import java.awt.*;
import java.awt.event.*;
class MenuExample
{
	MenuExample()
	{
		Frame f=new Frame("Simple Menu");
		MenuBar mb=new MenuBar();
		Menu menu=new Menu("Menu");
		Menu submenu=new Menu("submenu");
		MenuItem i1=new MenuItem("item1");
		MenuItem i2=new MenuItem("item2");
		MenuItem i3=new MenuItem("item3");
		MenuItem i4=new MenuItem("item4");
		MenuItem i5=new MenuItem("item5");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);
		f.setMenuBar(mb);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new MenuExample();
	}
}
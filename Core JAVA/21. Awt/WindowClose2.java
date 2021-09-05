import java.awt.*;
import java.awt.event.*;
class WindowClose2 extends WindowAdapter
{
	Frame f;
	WindowClose2()
	{
		f=new Frame();
		f.addWindowListener(this);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public void windowClosing(WindowEvent e)
	{
		f.dispose();
	}
	public static void main(String args[])
	{
		new WindowClose2();
	}
}
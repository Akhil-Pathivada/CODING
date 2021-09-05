import java.awt.*;
import java.awt.event.*;
class WindowClose extends Frame 
{
	WindowClose()
	{
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	public static void main(String args[])
	{
		new WindowClose();
	}
}
import java.awt.event.*;
import java.awt.*;
class PanelExample
{
	PanelExample()
	{
		Frame f=new Frame("Panel Example");
		
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
	}
	public static void main(String args[])
	{
		new PanelExample();
	}
}
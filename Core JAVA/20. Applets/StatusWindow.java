import java.awt.*;
import java.applet.*;
public class StatusWindow extends Applet
{
	public void init()
	{
		setBackground(Color.cyan);
	}
	public void paint(Graphics g)
	{
		g.drawString("This is an Applet window",10,20);
		showStatus("This is the Status Window");
	}
}

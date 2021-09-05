/* A simple applet that sets the foreground and
background colors and outputs a string. */
import java.awt.*;
import java.applet.*;
/*
<applet code="Sample" width=300 height=50>
</applet>
*/
public class Sample extends Applet
{
	String msg;
	// set the foreground and background colors.
	public void init() 
	{
		System.out.println("init");
		setBackground(Color.orange);
		setForeground(Color.red);
		//msg = "Inside init( ) --";
	}
	// Initialize the string to be displayed.
	public void start()
	{
		System.out.println("start");
		//msg += " Inside start( ) --";
	}
	// Display msg in applet window.
	public void paint(Graphics g) 
	{
		System.out.println("paint");
		//msg += " Inside paint( ).";
		//g.drawString(msg, 10, 30);
	}
}
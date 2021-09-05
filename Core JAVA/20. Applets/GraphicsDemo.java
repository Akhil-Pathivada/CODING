import java.awt.*;
import java.applet.Applet;
public class GraphicsDemo extends Applet
{
	String msg;
	public void start()
	{
		System.out.println("inside start...");
		msg+="Inside Start----";
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString("Welcome",50,50);
		g.drawLine(20,30,20,300);
		g.drawRect(70,100,30,30);
		g.fillRect(170,100,30,30);
		g.drawOval(70,200,30,30);
		g.setColor(Color.pink);
		g.fillOval(170,200,30,30);
		msg+="Inside paint----";
		System.out.println("inside paint...");
		g.drawString(msg,20,30);
	}
	
}
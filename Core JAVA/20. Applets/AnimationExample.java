import java.applet.*;
import java.awt.*;
public class AnimationExample extends Applet
{
	Image pic;
	public void init()
	{
		pic=getImage(getDocumentBase(),"giphy.gif");
	}
	public void paint(Graphics g)
	{
		for(int i=0;i<=500;i++)
		{
			g.drawImage(pic,i,30,this);
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e){}
		}
	}
}
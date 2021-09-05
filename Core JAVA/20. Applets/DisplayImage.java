import java.applet.*;
import java.awt.*;
public class DisplayImage extends Applet
{
	Image picture;
	public void init()
	{
		picture=getImage(getDocumentBase(),"IMG_20181021_125153.jpg");
	}
	public void paint(Graphics g)
	{
		g.drawImage(picture,20,30,this);
	}
}
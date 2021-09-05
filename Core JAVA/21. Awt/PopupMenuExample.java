// a simple Popupmenu Example
import java.awt.*;
import java.awt.event.*;
class PopupMenuExample
{
	PopupMenuExample()
	{
		Frame f=new Frame("PopupMenu Example");
		f.setSize(400,400);
		PopupMenu ppm=new PopupMenu("Edit");
		MenuItem copy=new MenuItem("copy");
		MenuItem cut=new MenuItem("cut");
		MenuItem paste=new MenuItem("paste");
		cut.setActionCommand("cut");
		copy.setActionCommand("copy");
		paste.setActionCommand("paste");
		ppm.add(cut);
		ppm.add(copy);
		ppm.add(paste);
		f.add(ppm);
		f.setLayout(null);
		f.setVisible(true);
		f.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				ppm.show(f,e.getX(),e.getY());
			}
		});
	}
	public static void main(String args[])
	{
		new PopupMenuExample();
	}
}
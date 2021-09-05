import java.awt.event.*;
import javax.swing.*;
class PopupMenuExample extends JFrame
{
	PopupMenuExample()
	{
		JPopupMenu ppm=new JPopupMenu();
		JMenuItem cut=new JMenuItem("cut");
		JMenuItem copy=new JMenuItem("copy");
		JMenuItem paste=new JMenuItem("paste");
		ppm.add(paste);
		ppm.add(copy);
		ppm.add(cut);
		add(ppm);
		setSize(400,400);
		setVisible(true);
		setLayout(null);
		addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				ppm.show(e.getComponent(),e.getX(),e.getY());
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new PopupMenuExample();
	}
}
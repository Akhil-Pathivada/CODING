import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
class TreeExample extends JFrame
{
	TreeExample()
	{
		DefaultMutableTreeNode style=new DefaultMutableTreeNode("style");
		DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");
		DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");
		style.add(color);
		style.add(font);
		DefaultMutableTreeNode pink=new DefaultMutableTreeNode("pink");
		DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");
		DefaultMutableTreeNode orange=new DefaultMutableTreeNode("orange");
		DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
		color.add(pink);
		color.add(green);
		color.add(orange);
		color.add(black);
		JTree jt=new JTree(style);
		add(jt);
		setVisible(true);
		//setLayout(null);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new TreeExample();
	}
}
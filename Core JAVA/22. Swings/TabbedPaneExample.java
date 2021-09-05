import javax.swing.*;
class TabbedPaneExample extends JFrame
{
	TabbedPaneExample()
	{
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JTextArea ta=new JTextArea(200,200);
		p1.add(ta);
		JTabbedPane tp=new JTabbedPane();
		tp.add("File",p1);
		tp.add("Edit",p2);
		tp.add("Search",p3);
		tp.setBounds(50,50,200,200);
		add(tp);
		setVisible(true);
		//setLayout(null);
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new TabbedPaneExample();
	}
}
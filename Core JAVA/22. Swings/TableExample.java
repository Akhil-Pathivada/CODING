import java.awt.event.*;
import javax.swing.*;
class TableExample
{
	TableExample()
	{
		JFrame f=new JFrame("A simple Table");
		String data[][]={ {"101","Amit","670000"},{"102","Jai","780000"},{"101","Sachin","700000"}};   
		String headings[]={"ID","NAME","SALARY"};
		JTable jt=new JTable(data,headings);
		f.setSize(400,400);
		f.add(jt);
		//JScrollPane sp=new JScrollPane(jt);    
		//f.add(sp);
		jt.setBounds(30,40,200,300);
		f.setLayout(null);
		f.setVisible(true);
		       
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[])
	{
		new TableExample();
	}
}
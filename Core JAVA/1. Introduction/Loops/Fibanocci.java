class Fibanocci
{
	public static void main(String args[])
	{
		int a=0,b=1,next;
		for(int i=0;i<8;next=a+b,a=b,b=next,i++) System.out.print(" "+b);//Printing first 8 Fibanocci numbers
	}
}
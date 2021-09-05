// This program includes a 'method' inside a 'Box' class
class Box
{
	double height;
	double width;
	double depth;
	void Volume()    // 'method' used to display volume of a box
	{
		System.out.print("\n Volume : ");
		System.out.println(width*height*depth);
	}	
}
class Methods_in_class
{
		public static void main(String args[])
		{
			
			Box mybox=new Box();
			Box mybox2=new Box();
			mybox.width=10;
			mybox.height=15;
			mybox.depth=20;
			mybox.Volume(); // Returns values of 'mybox'
			mybox2.width=3;
			mybox2.height=6;
			mybox2.depth=9;
			mybox2.Volume(); // Returns values of 'mybox2'
			
		}
}
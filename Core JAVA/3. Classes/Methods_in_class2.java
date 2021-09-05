// This program includes returning a value from a Method
class Box
{
	double height;
	double width;
	double depth;
	double Volume()    // 'method' used to display volume of a box
	{
		return (width*height*depth);
	}	
}
class Methods_in_class2
{
		public static void main(String args[])
		{
			Box mybox=new Box();
			Box mybox2=new Box();
			mybox.width=10;
			mybox.height=15;
			mybox.depth=20;
			double vol1=mybox.Volume();
			System.out.println("\n Volume 1 : "+vol1);
			mybox2.width=3;
			mybox2.height=6;
			mybox2.depth=9;
			double vol2=mybox2.Volume(); // Returns values of 'mybox2'
			System.out.println("\n Volume 2 : "+vol2);
			
		}
}
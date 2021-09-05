// A simple program about CLASS
class Box        // This class declares an object of type Box.
{
	double width;
	double height;
	double depth;
}
class Class_introduction
{
	public static void main(String args[])
	{
		double vol;
		Box mybox=new Box();  // 'mybox' is an Object of class 'Box'
		mybox.width=10;
		mybox.height=20;
		mybox.depth=15;
		vol=mybox.width*mybox.height*mybox.depth;
		System.out.println("\n Volume : "+vol);
	}
}
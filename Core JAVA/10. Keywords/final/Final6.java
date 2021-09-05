// 'static final blank variable' can be initialized only in static block.
class Final6
{
	static final int speed; // blank final variable
	Final6()
	{
		//speed=100; //compile error
		System.out.println("speed :" +speed);
	}
	static 
	{
		speed=100;
	}
	public static void main(String args[])
	{
		//speed=100; //compile error
		new Final6();
	}
}
/*
	speed :100
*/
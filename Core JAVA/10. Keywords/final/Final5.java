//we can initialise 'blank(unintialised)final variables' only in constructor.....
class Final5
{
	final int speed; // blank final variable
	Final5()
	{
		speed=100;
		System.out.println("speed :" +speed);
	}
	public static void main(String args[])
	{
		//speed=100; //compile error
		new Final5();
	}
}
/*
speed :100
*/
// Example of Hierarichal Inheritence ( one interface is implementing more classes)
interface Vehicle 
{  
    // all are the abstract methods. 
    void changeGear(int a); 
    void speedUp(int a); 
    void applyBrakes(int a); 
}   
class Bicycle implements Vehicle
{ 
    int speed = 0; 
    int gear; 
    public void changeGear(int num)
	{ 
        gear = num; 
    } 
    public void speedUp(int num)
	{   
        speed = speed + num;
    } 
    public void applyBrakes(int num)
	{ 
        speed = speed - num; 
    } 
      
    public void printStates() 
	{ 
         System.out.println("speed: " + speed + " gear: " + gear); 
    } 
} 
class Bike implements Vehicle 
{ 
      
    int speed=0; 
    int gear;
	public void changeGear(int num)
	{ 
        gear = num; 
    } 
    public void speedUp(int num)
	{   
        speed = speed + num;
    } 
    public void applyBrakes(int num)
	{   
        speed = speed - num; 
    }  
    public void printStates() 
	{ 
         System.out.println("speed: " + speed + " gear: " + gear); 
    } 
} 
class Example6
{   
    public static void main (String[] args)
	{ 
        // creating an inatance of Bicycle  
        Bicycle ob1 = new Bicycle(); 
        ob1.changeGear(2); 
        ob1.speedUp(3); 
        ob1.applyBrakes(1); 
        System.out.println("Bicycle present state :"); 
        ob1.printStates(); 
        // creating instance of bike. 
        Bike ob2 = new Bike(); 
        ob2.changeGear(1); 
        ob2.speedUp(4); 
        ob2.applyBrakes(3); 
        System.out.println("Bike present state :"); 
        ob2.printStates(); 
    } 
} 
/*

Bicycle present state :
speed: 2 gear: 2
Bike present state :
speed: 1 gear: 1

*/
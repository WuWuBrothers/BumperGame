import java.awt.Graphics;

//--------------------------------------------------
// Car class Implementation
// Author: Michael Wolljung
//--------------------------------------------------
public class Car extends Sprite{

	// private variables
	private String description;
	private GasTank tank;
	private Engine engine;

	
	// Constructor
	Car(String d, int maximumFuelCapacity, Engine e, String jpgName)
	{
		// Step:5 call the constructor of Sprite
		super(jpgName);
		
		tank = new GasTank(maximumFuelCapacity);
		
		// description is length zero set to Generic car.
		if(d.length() == 0)
		{
			d = "Generic car";
		}
		description = d; // description will be assigned Generic car if the length is empty

		// a new Engine is created with an empty description and 0's for all values if engine is null
		if(e == null)
		{
			engine = new Engine("", 0, 0);
		}
		else
			// if engine is already there us those values
			engine = e;
	}
	
	//----------------------------------------------
	// Methods
	//----------------------------------------------
	
	public String getDescription()
	{
		// An Argument Index
		return String.format("%s %s, fuel: %.2f/%d, location: (%d,%d)" , description, engine.getDescription(), tank.getLevel(), tank.getCapacity(), getX(), getY());
	}
	
	public double getFuelLevel()
	{
		return tank.getLevel();
	}
	
	public int getMPG()
	{
		 return engine.getMPG();
	}

	public void fillUp()
	{
		// set fuel level to maximum capacity
		tank.setLevel(tank.getCapacity());
	}
	
	public int getMaxSpeed()
	{
		return engine.getMaxSpeed();
	}
	
	public void updateImage(Graphics g){
		super.updateImage(g); // sprite is the parent class
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{	
		double destination;
		double hyperDrive;
		
		double hypotenuse = Math.sqrt(Math.pow(xRatio,2) + Math.pow(yRatio,2));
		
		hyperDrive = getMPG() * getFuelLevel();
		
		if(hyperDrive < distance){
			destination = hyperDrive;
			System.out.printf("Ran out of gas after driving %.2f miles.\n", hyperDrive);
		}
		else{
			destination = distance;
		}
		
		double gasConsumed = destination/getMPG();
		tank.setLevel(tank.getLevel() - gasConsumed);
		
		double adjacent = destination * (xRatio/hypotenuse);
		double opposite = destination * (yRatio/hypotenuse);
		
		 setX((int)adjacent + getX());
		 setY((int)opposite + getY());
		 
		return destination;
	}
}
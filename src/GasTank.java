//--------------------------------------------
// GasTank Class Implementation
// Author: Michael Wolljung
//--------------------------------------------

public class GasTank {
	//Private variables
	private int maximumCapacity;
	private double currentLevel;
	
	//----------------------------------------
	// Constructor
	//----------------------------------------
	GasTank(int capacity)
	{
		currentLevel = 0;
		
		if(capacity < 0)
		{
			capacity = 0;
		}
		maximumCapacity = capacity;
	}
	
	//----------------------------------------
	// Methods
	//----------------------------------------
	
	// Capacity of the gas tank
	public int getCapacity()
	{
		return maximumCapacity;
	}
	
	// Current level of gas in the tank
	public double getLevel()
	{
		return currentLevel;
	}
	
	// Set the level of gas in the car
	public void setLevel(double levelIn)
	{
		if(levelIn < 0)
			levelIn = 0;
		else if(levelIn > maximumCapacity)
		{
			currentLevel = maximumCapacity;
		}
		else if(levelIn <= maximumCapacity)
		{
			currentLevel = levelIn;
		}
			
	}
}
//--------------------------------------------------------
// Engine Class Implementation 
// Author: Michael Wolljung
//--------------------------------------------------------
public class Engine {

	//private variables
	private String description;
	private int milesPerGallon;
	private int maximumSpeedValue;
	
	//----------------------------------------------------
	// Constructor
	//----------------------------------------------------
	Engine(String d, int mpg, int msv)
	{
		// set the String of length "" to Generic engine
		if(d.length() == 0)
		{
			d = "Generic engine";
		}
		description = d;// description will be assigned Generic car if the length is empty
		
		// set the value of a negative mpg to zero
		if(mpg < 0)
		{
			mpg = 0;
		}
		milesPerGallon = mpg;
		
		// set the value of a negative msv to zero
		if(msv < 0)
		{
			msv = 0;
		}
		maximumSpeedValue = msv;
	}
	
	//----------------------------------------------------
	// Methods
	//----------------------------------------------------
	
	// Get the description of the engine
	public String getDescription()
	{
		// An Argument Index
		return String.format("(engine: %s (MPG: %d, Max speed: %d))", description, milesPerGallon, maximumSpeedValue);
	}
	
	// Get the Miles Per Gallon for the engine
	public int getMPG()
	{
		return milesPerGallon;
	}
	
	// Get the Maximum Speed for the engine
	public int getMaxSpeed()
	{
		return maximumSpeedValue;
	}
		
}
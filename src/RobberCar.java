import java.awt.Graphics;
import java.security.SecureRandom;

public class RobberCar extends Car {

	private int xRatio;
	private int yRatio;
	SecureRandom rand;
	private boolean arrested = false;
	private boolean free = false;
	// should count the captured/escaped at most once
	private static int totalArrested;
	private static int totalfree;
	
	RobberCar(){
		super("robber", 5000, new Engine("robberEngine", 30, 100), "red-car.jpg");
		rand = new SecureRandom();
		xRatio = rand.nextInt(11) - 5;
		yRatio = rand.nextInt(11) - 5;
		fillUp();
	}
	
	public void updateImage(Graphics g){
		super.updateImage(g);
	}

	public void captured(){
		arrested = true; // if true the car is captured and should stop moving
		setImage("jail.jpg"); // set the car image as a jail.jpg
		totalArrested++; // count the amount of cars caught 
	}
	
	public boolean isCaptured(){
		if(arrested){
			return true;
		}
		else
			return false;
	}
	
	public void updateState(int w, int h){
		// check the bounds of the window to see if the RobberCar has escaped.
		if(getX() >= w || getY() >= h || getX() <= 0 || getY() <= 0){
			totalfree++;
			free = true; // sets true the robber car has escaped and prints "I'm Free!" from model class
		}
		// if captured the car will stop moving 
		if(arrested == true){
			drive(0,xRatio,yRatio);
		}
		else
			drive(4, xRatio, yRatio);
	}
	
	public boolean hasEscaped(){
		if(free){
			return true;
		}
		else
			return false;
	}
	// set caught and escaped;
	
	public static void setCaught(){
		totalArrested = 0;
	}
	
	public static void setEscaped(){
		totalfree = 0;
	}
	
	public static int getCaught(){
		return totalArrested;
	}
	
	public static int getEscaped(){
		return totalfree;
	}
	
	public static void reset(){
		totalArrested = 0;
		totalfree = 0;
	}
}

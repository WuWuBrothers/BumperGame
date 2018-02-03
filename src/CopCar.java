import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car {
	
	private static int xRatio;
	private static int yRatio;
	
	int x = 1;
	int y = 1;
	
	Random rand;
	CopCar(){
		super("cop", 5000, new Engine("copEngine", 30, 100), "cop-car.jpg");
		rand = new Random();
		xRatio = rand.nextInt(11) - 5;
		yRatio = rand.nextInt(11) - 5;
		fillUp();
	}
	
	public void updateImage(Graphics g){
		super.updateImage(g);
	}
	
	public void updateState(int w, int h){
		
		// Test to see if the shape exceeds the boundaries of the screen
		// If it does, reverse its direction by multiplying by -1
		if(getY() <= 0 || getY() + 60 >= h){
			y *= -1;
		}
		if(getX() <= 0 || getX() + 60 >= w){
			x *= -1;
		}
		drive(2, x*xRatio, y*yRatio);
	}
}

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

class Sprite
{
	private String jpgName;
	protected int locationX;
	protected int locationY;
	private Image image;
	
	public Sprite(){
		
	}

	public Sprite(String jpgName)		// Step 3.
	{				   					 //Random rand = new Random();
		setImage(jpgName);
		locationX = 0;					 //locationX = rand.nextInt(780);
		locationY = 0;					 //locationY = rand.nextInt(270);
	}
	
	public int getX() { return locationX;}
	public int getY() { return locationY;}
	public void setX(int x) { locationX = x;}
	public void setY(int y) { locationY = y;}

	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {
        // Move the sprite
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	public void updateState(int w, int h){
		
	}
	
	public boolean overlaps(Sprite s){
		if(locationX > s.getX() - 60 && locationX < s.getX() + 60 ){
			if(locationY > s.getY() - 60 && locationY < s.getY() + 60){
				if(((RobberCar)s).isCaptured() == false){						//System.out.println("Gotcha!");
					((RobberCar)s).captured();
					return true;
				}
			}
		}
		return false;
	}
	
	
}

		

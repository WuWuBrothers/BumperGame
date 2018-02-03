import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Model
{
    private Sprite sprite;
    int index = 0;
    // create a ArrayList of Sprite objects 
    ArrayList<Sprite>images;
    
    
    Model() throws IOException {
    	images = new ArrayList<>();
    	Bank bank = new Bank(); 	
    	images.add(bank);	
    }

    public void addSprite(int x, int y){
    	synchronized(images)
    	{
        	if(index %2 == 0){
            	CopCar copCar = new CopCar();
        	    copCar.setX(x);				
        	    copCar.setY(y);						
        	    images.add(copCar);	
        	    copCar.updateState(x,y);
        	    index++;
        	}
        	else{
            	RobberCar robberCar = new RobberCar();
        	    robberCar.setX(300);			
        	    robberCar.setY(300);						
        	    images.add(robberCar);	
        	    robberCar.updateState(x,y);
        	    index++;
        	}
    	}
    }
    
/*    public void fillUp(){
    	Iterator<Sprite> iterator = images.iterator();
    	while(iterator.hasNext()){
    		Car car = (Car) iterator.next();
    		car.fillUp();
    	}
    }*/
    
    public void updateScene(int w, int h){
    	synchronized(images){
        	Iterator<Sprite> iterator = images.iterator();
        	while(iterator.hasNext()){
        		Sprite s = iterator.next();
        		s.updateState(w,h);
        	}
        	
    		Iterator <Sprite> iter = images.iterator();
        	while(iter.hasNext()){
        		Sprite robberCaught = iter.next();
        		if(robberCaught instanceof RobberCar){
        			if(((RobberCar)robberCaught).hasEscaped()){
        				iter.remove();
        				System.out.println("I'm Free!");
        			}
        		}
        	}
        	
        	/*instanceof tests whether the object reference on the left-hand side (LHS) 
        	is an instance of the type on the right-hand side (RHS) or some subtype.*/
        	for(int image1 = 1; image1 < images.size(); image1 ++){
        		if(images.get(image1) instanceof CopCar){
        			for(int image2 = 1; image2 < images.size(); image2++){
        				if(images.get(image2) instanceof RobberCar){
        					images.get(image1).overlaps(images.get(image2));
        				}
        			}
        		}
        	}
    	}
    }
    public void update(Graphics g) {
    	synchronized(images){
        	for(int i = 0; i < images.size(); i++){
            	images.get(i).updateImage(g);
            }
    	}
    }
    
    public void initialize(){
    	// Which one is better to use?
    	// images.removeAll(images);
    	synchronized(images){
    		images.clear();
        	// Source code
        	// public void clear(){
        	//		modCount++;
        	//		for(int i =0; i < size; i++){
        	//			elementData[i] = null;
        	//		}
        	//		size = 0;
        	//}
        	Bank newBank = new Bank();
        	images.add(newBank);
        	RobberCar.reset();
    	}
    }
}
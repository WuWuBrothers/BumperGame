import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;
    RobberCar thug;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
       // new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
    	view.repaint();
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Gets here is left mouse button was clicked
			int x , y;
			x = e.getX();
			y = e.getY();
			model.addSprite(x, y);
		} else if (SwingUtilities.isRightMouseButton(e))  {
			// Gets here if right mouse button was clicked
			model.updateScene(view.getWidth(),view.getHeight());
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }

	@Override
	public void keyPressed(KeyEvent e1) {

	}

	@Override
	public void keyReleased(KeyEvent e2) {
		
	}

	@Override
	public void keyTyped(KeyEvent e3) {
		if(e3.getKeyChar() == 'h'){
			System.out.println("Hello, World!");
		}
		if(e3.getKeyChar() == 'n'){
			System.out.printf("Total arrests: %d! \n", thug.getCaught()); 
			System.out.printf("Total excapees: %d! \n", thug.getEscaped());
		}
		if(e3.getKeyChar() == 'r'){
			model.initialize();
			view.repaint();
		}
		if(e3.getKeyChar() == 's'){
			Thread thread = new Thread(new SpriteMover(model,view));
			thread.start();
		}
	}
}
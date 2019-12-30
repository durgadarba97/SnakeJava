package snake;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener{
	
	private boolean isPressed;
	
	public Mouse()
	{
		
	}
	
	public boolean isPressed()
	{
		return isPressed;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == 1 || e.getButton() == 3)
			isPressed = true;
		else
			isPressed = false;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() != 1 || e.getButton() != 3)
			isPressed = false;
		else
			isPressed = true;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

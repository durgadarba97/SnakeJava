package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

	private boolean [] keys;
	public boolean up, down, left, right, test;
	
	public Keyboard()
	{
		keys = new boolean[256];
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		test = keys[KeyEvent.VK_0];
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println("pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		System.out.println("released");
		
	}

}

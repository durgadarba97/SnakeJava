package snake;

import java.awt.Graphics;

public abstract class AbstractState {
	
	private static AbstractState currState = null;
	protected Game game;
	
	public AbstractState(Game g)
	{
		game = g;
	}
	
	public static void setState(AbstractState state)
	{
		currState = state;
	}
	
	public static AbstractState getState()
	{
		return currState;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}

package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class EndState extends AbstractState{
	
	Game game;

	public EndState(Game g) {
		super(g);
	}

	@Override
	public void update() {
		if(super.game.getMouse().isPressed())
		{
			super.game.restart();
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(248, 131, 121));
		
		g.setFont(new Font("default", Font.BOLD, 50));
		g.drawString("GAME OVER", 40 , 100);
		
		String str = "Your score was " + Game.getScore();
		
		g.setColor(Color.darkGray);
		g.setFont(new Font("default", Font.BOLD, 25));
		g.drawString(str, 85, 200);
		
	}

}

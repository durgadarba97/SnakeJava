package snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class GameplayState extends AbstractState{
	
	public static Snake snake;
	public Food foodPoint;
	private Game game;
	public static int score;
	
	
	public GameplayState(Game g) {
		super(g);
		game = g;
		
		snake = new Snake(g, 100, 100, Constants.TILE, Constants.TILE);
		foodPoint = new Food();
		score = 0;
		
		snake.addBlock();
		snake.addBlock();
		snake.addBlock();
		snake.addBlock();
	}
	
	public boolean isFoodEaten()
	{
		if(foodPoint.getX() == snake.getSnakeXPos() && foodPoint.getY() == snake.getSnakeYPos())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasCollided()
	{
		ArrayList<Point> points = snake.points;
		Iterator<Point> iter = points.iterator();
		iter.next();
		Point head = snake.head.point;
		iter.next();
		Point iterpos;
		
		while(iter.hasNext())
		{
			iterpos = iter.next();
			
			if(iterpos.x == head.x && iterpos.y == head.y)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hitEdge()
	{
		Point point = snake.points.get(0);
		
		if(point.x > 400 || point.y > 400  || point.x < 0 || point.y < 0)
			return true;
		else
			return false;
	}
	
	@Override
	public void update() {
		
		if(hasCollided() || hitEdge())
		{
			System.out.println("collided is called");
			System.out.println(score);
			game.setScore(score);
			super.setState(new EndState(game));
		}
		else
		{
			if(isFoodEaten())
			{
				score+=10;
				foodPoint.setFoodPoint();
				snake.addBlock();
				snake.addBlock();
				snake.addBlock();
			}
	
			snake.update();
			foodPoint.update();
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		snake.render(g);	
		foodPoint.render(g);
	}
	
	public Snake getSnake()
	{
		return snake;
	}
	
	public static int getScore()
	{
		return score;
	}
	

	
}

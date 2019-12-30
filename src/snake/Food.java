package snake;

import java.awt.Color;
import java.awt.Graphics;

public class Food {
	
	
	public Point foodPoint;
	
	
	public Food()
	{
		int x = ((int) Math.floor(Math.random()*3.81)*100) + Constants.TILE;
		int y = ((int) Math.floor(Math.random()*3.81)*100) + Constants.TILE;
		
		foodPoint = new Point(x, y);
		
		System.out.println(foodPoint.x + " " + foodPoint.y);
	}
	
	public void setFoodPoint()
	{
		int x = ((int) Math.floor(Math.random()*3.81)*100) + Constants.TILE;
		int y = ((int) Math.floor(Math.random()*3.81)*100) + Constants.TILE;
		
		foodPoint.setPoint(x, y);
		
		System.out.println(foodPoint.x + " " + foodPoint.y);
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g)
	{
		Color c = new Color(248, 131, 121);
		g.setColor(c);
		g.fillRect(foodPoint.x, foodPoint.y, Constants.TILE, Constants.TILE);
	}
	
	public int getX()
	{
		return foodPoint.x;
	}
	
	public int getY()
	{
		return foodPoint.y;
	}
	
	
	
	
}

package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;


public class Snake {
	
	protected class Block
	{
		protected Block parent;
		protected Block child;
		protected int width;
		protected int height;

		protected Point point;
		
		public Block(int x, int y, int w, int h)
		{
			parent = null;
			child = null;
			
			point = new Point(x, y);
			
			width = w;
			height = h;
		}
		
	}
	
	public Block head;
	public Rectangle tail;
	public Game game;
	public int direction;
	public int olddirection;
	public ArrayList<Point> points;
	
	public Snake(Game g, int x, int y, int w, int h)
	{
		game = g;
		direction = 2;
		head = new Block(x, y, w, h);
		
		points = new ArrayList<Point>();
		points.add(head.point);

		System.out.println(head.point.x + " " + head.point.y + " " + head.width + " " + head.height);
		
	}
	
	public Block getLastSnake()
	{
		Block iter = head;
		while(iter.child != null)
		{
			iter = iter.child;
		}
		
		return iter;
	}
	
	
	public void addBlock()
	{
		Block lastSnake = getLastSnake();
		Block newSnake = null;
		
		if(direction == 1)
		{
			newSnake = new Block(lastSnake.point.x, (lastSnake.point.y+Constants.TILE), lastSnake.width, lastSnake.height);
			lastSnake.child = newSnake;
			newSnake.parent = lastSnake;
		}
		else if(direction == 2)
		{		
			newSnake = new Block(lastSnake.point.x, (lastSnake.point.y-Constants.TILE), lastSnake.width, lastSnake.height);
			lastSnake.child = newSnake;
			newSnake.parent = lastSnake;
		}
		else if(direction == 3)
		{
			newSnake = new Block((lastSnake.point.x-Constants.TILE), lastSnake.point.y, lastSnake.width, lastSnake.height);
			lastSnake.child = newSnake;
			newSnake.parent = lastSnake;
		}
		else if(direction == 4)
		{
			newSnake = new Block((lastSnake.point.x+Constants.TILE), lastSnake.point.y, lastSnake.width, lastSnake.height);
			lastSnake.child = newSnake;
			newSnake.parent = lastSnake;
		}
		
		points.add(newSnake.point);

		
	}
	
	
	public void update()
	{
		setDirection(game.getKeyboard());
		
		if(direction == 1)
		{
			moveSnake(-Constants.TILE);
		}
		else if(direction == 2)
		{
			moveSnake(Constants.TILE);
		} 
		else if(direction == 3)
		{
			moveSnake(-Constants.TILE);
		}
		else if(direction == 4)
		{
			moveSnake(Constants.TILE);
		}
			
	}
	
	public void moveSnake(int move)
	{
		Block iter = head;
		int ax = iter.point.x;
		int ay = iter.point.y;
		int bx;
		int by;
		
		if(direction == 1 || direction == 2)
			iter.point.y += move;
		else if(direction == 3 || direction == 4)
			iter.point.x += move;
		
		
		while(iter.child != null)
		{	
			iter = iter.child;
			
			bx = iter.point.x;
			by = iter.point.y;
			
			iter.point.x = ax;
			iter.point.y = ay;
			
			if(iter.child != null)
			{
				iter = iter.child;
			
				ax = iter.point.x;
				ay = iter.point.y;
			
				iter.point.x = bx;
				iter.point.y = by;
			}
		}
		
		updateList();
		
	}
	
	public void setDirection(Keyboard k)
	{
		if(k.up && direction != 2)
		{
			direction = 1;
		}
		else if(k.down  && direction != 1)
		{
			direction = 2;
		} else if(k.left  && direction != 4)
		{
			direction = 3;
		}else if(k.right  && direction != 3)
		{
			direction = 4;
		}
	} 
	
	public void updateList()
	{
		Block iter = head;

		int i = 1;
		while(iter.child != null)
		{
			points.set(i, iter.point);
			iter = iter.child;
			i++;
		}

	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.darkGray);
		
		Block iter = head;
		g.fillRect(iter.point.x, iter.point.y, iter.width, iter.height);
		
		while(iter.child != null)
		{
			g.fillRect(iter.point.x, iter.point.y, iter.width, iter.height);
			iter = iter.child;
		}
	}
	
	public int getSnakeXPos()
	{
		return head.point.x;
	}
	
	public int getSnakeYPos()
	{
		return head.point.y;
	}
	
}

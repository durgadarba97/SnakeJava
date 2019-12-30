package snake;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
	private World world;
	
	public int width, height;
	public String title;
	private boolean running;
	private BufferStrategy bs;
	private Graphics g;
	
	public Thread thread;
	
	private AbstractState state;
	public GameplayState gameplaystate;
	public EndState endstate;
	
	private Keyboard keyboard;
	private Mouse mouse;
	
	private static int score;
	
	public Game(String t, int w, int h) 
	{
		width = w;
		height = h;
		title = t;
		keyboard = new Keyboard();
		mouse = new Mouse();
	}
	
	private void init()
	{
		world = new World(this, title, width, height);	
		world.getFrame().addKeyListener(keyboard);
		
		world.getFrame().addMouseListener(mouse);
		world.getFrame().addMouseMotionListener(mouse);
		world.getCanvas().addMouseListener(mouse);
		world.getCanvas().addMouseMotionListener(mouse);
		
		
		gameplaystate = new GameplayState(this);
		endstate = new EndState(this);
		
		
		state = gameplaystate;
		AbstractState.setState(state);
	}
	
	
	private void update()
	{
		keyboard.update();
		if(AbstractState.getState() != null)
		{
			AbstractState.getState().update();
		}
			
	}
	
	private void render()
	{
		bs = world.getCanvas().getBufferStrategy();
		
		if(bs == null)
		{
			world.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//Draw below:
		
		if(AbstractState.getState() != null)
			AbstractState.getState().render(g);
		
		//done drawing;
		
		bs.show();
		g.dispose();
	}
	
	public synchronized void run()
	{
		init();
		
		int tps = 10;
		double timepertick = 1000000000/ tps;
		double changeTime = 0;
		long lastTime = System.nanoTime();
		long currTime;
		
		while(running)
		{
			currTime = System.nanoTime();
			changeTime += (currTime - lastTime) / timepertick;
			lastTime = currTime;
			
			
			if(changeTime >= 1)
			{
				update();
				render();	
				changeTime--;
			}
			

		}
		
		stop();
	}
	
	public synchronized void start()
	{
		if(running) return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	public synchronized void stop()
	{
		if(!running) return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.out.println("Could not end thread");
			e.printStackTrace();
		}
	}
	
	public void restart()
	{
		init();
	}
	
	public Keyboard getKeyboard()
	{
		return keyboard;
	}
	
	public Mouse getMouse()
	{
		return mouse;
	}
	
	public static int getScore()
	{
		return score;
	}
	
	public void setScore(int s)
	{
		score = s; 
	}
}

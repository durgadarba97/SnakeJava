package snake;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class World {
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	public Snake snake;
	
	public World(Game g, String t, int w, int h)
	{
		title = t;
		width = w;
		height = h;		
		createFrame();
	}
	
	public void createFrame()
	{
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		Dimension d = new Dimension(width, height);
		canvas.setPreferredSize(d);
		canvas.setMaximumSize(d);
		canvas.setMinimumSize(d);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}


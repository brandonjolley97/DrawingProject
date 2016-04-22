package drawing.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ShapePane extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	
	public ShapePane()
	{
		rectangleList = new ArrayList<Rectangle>();
	}
	
	public void addRectangle()
	{
		rectangleList.add(new Rectangle(10, 20, 50, 10));
	}

	protected void paintComponent(Graphics currentGraphics)
	{
		
	}
}



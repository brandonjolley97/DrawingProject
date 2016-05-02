package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	private ArrayList<Rectangle> barList;
	
	public GraphPanel()
	{
		graphSource = new int [10];
		barList = new ArrayList<Rectangle>();
		
		fillArray();
		addValue();
		//initialize graphSource here.
	}
	
	public void fillArray()
	{
		for(int index = 0; index < graphSource.length; index++)
		{
			int randomInt = (int)(Math.random() *100);
			graphSource[index] = randomInt;
			//Fill the array.
		}
	}
	
	public void addValue()
	{
		for(int index = 0; index < graphSource.length; index++)
		{
			int height = 50;
			int xPosition = height * index;
			int yPosition = 0;
			int width = graphSource[index];
			//Draw a rectangle for each value in the array.
			barList.add(new Rectangle(xPosition, yPosition, height, width));
		}
	}
	
	public void clearBarList()
	{
		barList.clear();
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(5));
		
		for(Rectangle current : barList)
		{
			int randomStroke = (int)(Math.random() * 7);
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(randomStroke));
			
			mainGraphics.fill(current);
		}
		
	}
		
		
}

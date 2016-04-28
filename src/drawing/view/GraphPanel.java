package drawing.view;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GraphPanel extends JPanel
{
	private int [] graphSource;
	
	public GraphPanel()
	{
		graphSource = new int [10];
		//initialize graphSource here.
	}
	
	public void addValue()
	{
		
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		
		for(int index = 0; index < graphSource.length; index++)
		{
			int randomInt = (int)(Math.random() *100);
			graphSource[index] = randomInt;
			//Fill the array.
		}
		
		for(int index = 0; index < graphSource.length; index++)
		{
			int height = 50;
			int xPosition = height * index;
			int yPosition = 0;
			int width = graphSource[index];
			//Draw a rectangle for each value in the array.
		}
	}
}

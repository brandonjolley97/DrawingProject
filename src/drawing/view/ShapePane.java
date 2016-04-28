package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ShapePane extends JPanel
{
	private ArrayList<Rectangle> rectangleList;
	private ArrayList<Rectangle> squareList;
	private ArrayList<Polygon> triangleList;
	private ArrayList<Polygon> polygonList;
	private ArrayList<Ellipse2D> ellipseList;
	private ArrayList<Ellipse2D> circleList;
	
	public ShapePane()
	{
		triangleList = new ArrayList<Polygon>();
		rectangleList = new ArrayList<Rectangle>();
		squareList = new ArrayList<Rectangle>();
		polygonList = new ArrayList<Polygon>();
		ellipseList = new ArrayList<Ellipse2D>();
		circleList = new ArrayList<Ellipse2D>();
	}
	
	public void addRectangle()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 600);
		int width = (int)(Math.random() * 50);
		int height = (int)(Math.random() * 50);		
		
		rectangleList.add(new Rectangle(xPosition, yPosition, width, height));
	}
	
	public void addSquare()
	{
		int xPosition = (int)(Math.random() * 600);
		int yPosition = (int)(Math.random() * 600);
		int size = (int)(Math.random() * 50);	
		
		squareList.add(new Rectangle(xPosition, yPosition, size, size));
	}
	
	public void addTriangle()
	{
		int [] xPoints = new int[3];
		int [] yPoints = new int[3];
		xPoints[0] = (int)(Math.random() * 250);
		
		xPoints = new int []{(int)(Math.random() * 600), (int)(Math.random() * 600), (int)(Math.random() * 600)};
		yPoints = new int []{(int)(Math.random() * 600), (int)(Math.random() * 600), (int)(Math.random() * 600)};
		
		Polygon triangle = new Polygon(xPoints, yPoints, 3);
		
		triangleList.add(triangle);
	}
	
	public void addPolygon()
	{
		int numberOfSides = (int)(Math.random() * 10) + 3;
		int [] xPoints = new int[numberOfSides];
		int [] yPoints = new int[numberOfSides];
		
		for(int sides = 0; sides < numberOfSides; sides++)
		{
			xPoints[sides] = (int)(Math.random() * 600);
			yPoints[sides] = (int)(Math.random() * 600);
		}
		
		Polygon myPolygon = new Polygon(xPoints, yPoints, numberOfSides);
		polygonList.add(myPolygon);
	}
	
	public void addEllipse()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int width = (int)(Math.random() * 100);
		int height = (int)(Math.random() * 100);
		
		Ellipse2D ellipse = new Ellipse2D.Double(xPoint, yPoint, width, height);
		ellipseList.add(ellipse);
	}
	
	public void addCircle()
	{
		int xPoint = (int)(Math.random() * 1000);
		int yPoint = (int)(Math.random() * 1000);
		int diameter = (int)(Math.random() * 100);
		
		Ellipse2D circle = new Ellipse2D.Double(xPoint, yPoint, diameter, diameter);
		circleList.add(circle);
	}

	private void drawShapes(Graphics2D mainGraphics, ArrayList shapeList)
	{
		for(Object currentShape : shapeList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int pencilSize = (int)(Math.random() * 10) + 3;
			
			mainGraphics.setColor(new Color(red, green, blue));
			mainGraphics.setStroke(new BasicStroke(pencilSize));
			if(currentShape instanceof Polygon)
			{
				
			}
		}
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90, 10, 20, 40));
		
		for(Polygon current : polygonList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(current);
		}
		
		for(Polygon triangle : triangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			int pencilSize = (int)(Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(triangle);
		}
		
		for(Rectangle rectangle : rectangleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			int pencilSize = (int)(Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(rectangle);
		}
		
		for(Rectangle rectangle : squareList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			int pencilSize = (int)(Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(rectangle);
		}
		
		for(Ellipse2D ellipse : ellipseList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			int pencilSize = (int)(Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(ellipse);
		}
		
		for(Ellipse2D circle : circleList)
		{
			int red = (int)(Math.random() * 256);
			int green = (int)(Math.random() * 256);
			int blue = (int)(Math.random() * 256);
			int alpha = (int)(Math.random() * 255);
			
			int pencilSize = (int)(Math.random() * 15);
			
			mainGraphics.setColor(new Color(red, green, blue, alpha));
			
			mainGraphics.fill(circle);
		}
	}
	
	public void clear()
	{
		triangleList.clear();
		circleList.clear();
		ellipseList.clear();
		rectangleList.clear();
		squareList.clear();
		polygonList.clear();
	}
}



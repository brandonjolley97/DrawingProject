package drawing.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import drawing.controller.DrawingController;
import drawing.view.ShapePane;

public class DrawingPane extends JPanel
{
	private DrawingController baseController;
	private SpringLayout baseLayout;
	private ShapePane shapePanel;
	private JButton drawRectangleButton;
	private JButton drawSquareButton;
	private JButton drawCircleButton;
	private JButton drawEllipseButton;
	private JButton drawTriangleButton;
	private JButton drawPolygonButton;
	private JButton clearButton;
	private ArrayList<Rectangle> rectangleList;
	
	public DrawingPane(DrawingController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		shapePanel = new ShapePane();
		rectangleList = new ArrayList<Rectangle>();
		clearButton = new JButton("Clear all the things!");
		drawRectangleButton = new JButton("Draw the rectangle");
		drawCircleButton = new JButton("Draw the circle");
		drawTriangleButton = new JButton("Draw the triangle");
		drawPolygonButton = new JButton("Draw the polygon");
		drawSquareButton = new JButton("Draw the square");
		drawEllipseButton = new JButton("Draw the ellipse");
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	public void setupPanel()
	{
		this.add(drawSquareButton);
		this.add(drawRectangleButton);
		this.add(drawCircleButton);
		this.add(drawPolygonButton);
		this.add(drawTriangleButton);
		this.add(drawEllipseButton);
		this.add(clearButton);
		this.add(shapePanel);
		this.setLayout(baseLayout);
	}
	
	public void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, drawRectangleButton, 6, SpringLayout.SOUTH, clearButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawTriangleButton, 0, SpringLayout.WEST, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawTriangleButton, 8, SpringLayout.SOUTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawEllipseButton, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, shapePanel, 12, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, shapePanel, 12, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, shapePanel, -12, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, shapePanel, -12, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, drawEllipseButton, 0, SpringLayout.WEST, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawSquareButton, 20, SpringLayout.EAST, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawCircleButton, 0, SpringLayout.WEST, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, drawCircleButton, -6, SpringLayout.NORTH, drawSquareButton);
		baseLayout.putConstraint(SpringLayout.NORTH, drawSquareButton, 0, SpringLayout.NORTH, drawPolygonButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawRectangleButton, 0, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, drawPolygonButton, 10, SpringLayout.SOUTH, drawRectangleButton);
		baseLayout.putConstraint(SpringLayout.WEST, drawPolygonButton, 0, SpringLayout.WEST, drawRectangleButton);
	}
	
	public void setupListeners()
	{
		drawRectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangle();
				repaint();
			} 
		});
		
		drawCircleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addCircle();
				repaint();
			} 
		});
		
		drawEllipseButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addEllipse();
				repaint();
			} 
		});
		
		drawTriangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addTriangle();
				repaint();
			} 
		});
		
		drawPolygonButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addPolygon();
				repaint();
			} 
		});
		
		drawSquareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addSquare();
				repaint();
			} 
		});
		
		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.clear();
			} 
		});
		
	}
	
	protected void paintComponent(Graphics currentGraphics)
	{
		super.paintComponent(currentGraphics);
		Graphics2D mainGraphics = (Graphics2D)currentGraphics;
		mainGraphics.setColor(Color.GREEN);
		mainGraphics.setStroke(new BasicStroke(5));
		mainGraphics.draw(new Rectangle(90, 10, 20, 40));
		
		for(Rectangle current : rectangleList)
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

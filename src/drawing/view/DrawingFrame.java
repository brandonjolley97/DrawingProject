package drawing.view;

import javax.swing.*;
import drawing.controller.*;

public class DrawingFrame extends JFrame
{
	private DrawingController baseController;
	private DrawingPane basePanel;
	
	public DrawingFrame(DrawingController baseController)
	{
		this.baseController = baseController;
		this.basePanel = new DrawingPane(baseController);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600, 600);
		this.setTitle("DRAW!");
		this.setVisible(true);
	}
}

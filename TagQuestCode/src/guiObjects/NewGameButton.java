package guiObjects;

import rpgElements.*;

public class NewGameButton extends Button {

	protected AdventureHandler call;
	public NewGameButton(String image, String image2, AdventureHandler caller)
	{
		call = caller;
		buttonUp = image;
		buttonDown = image2;
		init("startButton.jpg");
		
	}
	public NewGameButton(String image, String image2, String input,
			Player inputReceive) 
	{
		super(image, image2, input, inputReceive);
		// TODO Auto-generated constructor stub
	}

	public NewGameButton(int xPosition, int yPosition) 
	{
		super(xPosition, yPosition);
		// TODO Auto-generated constructor stub
	}
	
	public void onClick()
	{
		call.playSetUp();
	}

}

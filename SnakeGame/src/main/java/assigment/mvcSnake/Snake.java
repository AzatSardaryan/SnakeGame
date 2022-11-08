package assigment.mvcSnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Snake extends GameObject{
	
	
	
	public Snake(int x, int y, GraphicsContext gc, Pane root) {
		super(x, y, gc, root);
		
	}
	
	
	@Override 
	
	// override the update method and set the colour of the snake to dark green
	public void update() {
		gc.setFill(Color.DARKGREEN);
		gc.fillRect(x * Main.BLOCK_SIZE, y * Main.BLOCK_SIZE,Main.BLOCK_SIZE, Main.BLOCK_SIZE);  
	}
	
	
		
		
		
	
		
		
		
}

package assigment.mvcSnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class Factory implements  FactoryIF{
	
	// references to the graphics context and pane. 
	GraphicsContext gc; 
	Pane root; 
	

	public Factory(GraphicsContext gc, Pane root) {
		super();
		this.gc = gc; 
		this.root = root; 
	}
	@Override
	
	// a method that returns a game object depending on the discrim parameter
	public GameObject createProduct(String discrim, int x, int y) {
		if(discrim.equals("Gold")) return new GoldApple(x,y, gc, root); 
		if(discrim.equals("Red")) return new RedApple(x,y, gc, root); 
		if(discrim.equals("Blue")) return new BlueApple(x,y, gc, root); 
		return null;
	}
	


}

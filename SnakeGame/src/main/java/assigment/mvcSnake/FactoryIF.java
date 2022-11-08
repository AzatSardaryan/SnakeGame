package assigment.mvcSnake;

import javafx.scene.layout.Pane;


// interface to allow for easy object creation
public interface FactoryIF {
	GameObject createProduct(String discrim, int x, int y);

	
}

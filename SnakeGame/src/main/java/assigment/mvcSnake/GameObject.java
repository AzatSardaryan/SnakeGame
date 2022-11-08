package assigment.mvcSnake;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;




// super class of all game objects to hold common fields
public class GameObject {
		protected int x,y; 
		protected Image img;
		protected GraphicsContext gc; 
		protected Pane root;
		
		
		
		// all objects have an x and y coordinate and a refernece to the graphics context 
		public GameObject(int x, int y, GraphicsContext gc, Pane root) {
			super();
			this.x = x;
			this.root = root; 
			this.y = y; 
			this.gc = gc; 
		}
		
		
		// update method to display the game objects to the screen 
		public void update() {
			if(img != null) {
				gc.drawImage(img, x * Main.BLOCK_SIZE, y * Main.BLOCK_SIZE , Main.BLOCK_SIZE, Main.BLOCK_SIZE);
			}
		}
		
		
		
}


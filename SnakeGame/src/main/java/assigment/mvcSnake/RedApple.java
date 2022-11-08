package assigment.mvcSnake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;

public class RedApple extends GameObject{
	
	private String MEDIA_URL = "sample.wav"; 
	
	public RedApple(int x, int y, GraphicsContext gc, Pane root) {
		// passing the img parameter the file name of the image
		super(x, y, gc, root);
		img=new Image(RedApple.class.getResource("redApple.png").toExternalForm()); 
		
	}
	

	
	public void update() {
		if(img != null) {
			// x and y are multiplied by the block size in order to ensure that the image ends up perfectly inside a one of the grid units
			gc.drawImage(img, x * Main.BLOCK_SIZE, y * Main.BLOCK_SIZE , Main.BLOCK_SIZE, Main.BLOCK_SIZE);
		}
	}
	
	public void play_audio() {
		AudioClip audio = new AudioClip(this.getClass().getResource(MEDIA_URL).toString()); 
		
		audio.play();
	}

}

 package assigment.mvcSnake;



import java.util.Random;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class Main extends Application{
	
	
	Pane root;
	Scene scene; 
	Canvas canvas;
	GraphicsContext gc; 
	Model model; 
	View view; 
	Controller controller; 
	// declaring the screen width and height and how many blocks there will be
	static final int SCREEN_WIDTH = 625;  
	static final int SCREEN_HEIGHT = 625; 
	static final int BLOCK_SIZE = 25; 
	
	
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// set up for the user interface
		root = new Pane(); 
		scene = new Scene(root, SCREEN_WIDTH,SCREEN_HEIGHT); 
		canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT); 
		gc = canvas.getGraphicsContext2D();
		primaryStage.setScene(scene);
		primaryStage.show(); 
		String MEDIA_URL = Main.class.getResource("backroundMusic.mp3").toExternalForm();
		Media media = new Media(MEDIA_URL);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		root.getChildren().add(mediaView);
		root.getChildren().add(canvas); 
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		model = new Model();
		view = new View(root, model, scene, canvas, gc); 
		controller = new Controller(model, view, canvas);
		controller.startGame();
		
	}
	
	
	
	
	
	// launching the JavaFX application
	public static void main(String[] args) {
		launch(args); 
	}
	
	
		
	
	
	
	
}


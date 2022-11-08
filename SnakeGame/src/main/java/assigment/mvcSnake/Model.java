package assigment.mvcSnake;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;



public class Model {
	
	// Fields needed for the game to function 
	GameObject food = null; 
	private Random random = new Random();
	ArrayList<Snake> snake = new ArrayList<Snake>();
	private Factory factory; 
	boolean isGameOver = false; 
	int score = 0; 
	private AudioClip noise = new AudioClip(this.getClass().getResource("AppleBite.wav").toString());
	private AudioClip noise2 = new AudioClip(this.getClass().getResource("classiccoin.wav").toString());
	private AudioClip noise3 = new AudioClip(this.getClass().getResource("sweep.wav").toString());
	String question1 = "What is the largest planet in the solar system?"; 
	String question2 = "At what temperature does water start to freeze?"; 
	String question3 = "Which scientist discovered gravity?"; 
	String correctAnswer1 = "Jupiter"; 
	String correctAnswer2 = "0 Degrees"; 
	String correctAnswer3 = "Isaac Newton"; 
	String[] answers1 = {"Mercury", "Mars", "Jupiter", "Uranus"};
	String[] answers2 = {"0 Degrees", "5 Degrees", "-5 Degress", "10 Degrees"};
	String[] answers3 = {"Isaac Newton", "Albert Einstein", "Stephen Hawking", "Brian Cox"};
	int currentQuestion = 1; 
	
	
	public void newFood(GraphicsContext gc, Pane root) {
		
		// Instantiate factory
		this.factory = new Factory(gc, root);
		
		// make a new random number between 1 and 3 to decide what apple comes next 
		int ij = random.nextInt(3)+1; 
		int yc;
		int xc;
		boolean collide = true; 
		
		// make another 2 random numbers between 0 and 24 for the x and y coordinates 
		xc = (int) (Math.random() * Main.BLOCK_SIZE); 
		yc = (int) (Math.random() * Main.BLOCK_SIZE); 
				
				while (collide) {
					for(Snake s: snake) {
						if(s.x == xc && s.y == yc) {
							
							// if the new coordinates of the apple clash with the snake body keep on generating new x and y
							xc = (int) (Math.random() * Main.BLOCK_SIZE); 
							yc = (int) (Math.random() * Main.BLOCK_SIZE); 
						}
						else {
							collide = false; 
							}
						}
					}
				
				// depending on the random number generated from 1 to 3 make the corresponding apple
						if(ij == 1) {
							this.food = factory.createProduct("Red", xc, yc);
							
						}
						else if(ij == 2) {
							this.food = factory.createProduct("Gold", xc, yc); 
							
						}
						else if(ij == 3) {
							this.food = factory.createProduct("Blue", xc, yc);
						}
						
					
				}
				
	
	
	
	
	// method to add the starting snake to the screen
	public void addStartSnake(GraphicsContext gc, Pane root) {
		
		// set the snake up in the middle of the screen 
		snake.add(new Snake(Main.BLOCK_SIZE /2, Main.BLOCK_SIZE /2, gc, root)); 
		snake.add(new Snake(Main.BLOCK_SIZE /2, Main.BLOCK_SIZE /2, gc, root)); 
		snake.add(new Snake(Main.BLOCK_SIZE /2, Main.BLOCK_SIZE /2, gc, root)); 
		
	}
	
	
	// method to add a snake body and generate a new apple once the snake has eaten 
	public void addSnakeBody(GraphicsContext gc, Pane root) {
		snake.add(new Snake(-5,-5, gc, root));
		
		if(food instanceof RedApple) {
			
			noise.play();
		}
		else if(food instanceof GoldApple) {
			
			noise2.play();
		}
		
		else if(food instanceof BlueApple) {
			noise3.play();
		}
		
			
		newFood(gc, root); 
	}
	
	
	// method to check if the snake has collided with its own body
	public void checkHeadCollision() {
		for(int i = 1; i < snake.size() ; i++) {
			if(snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
				isGameOver = true; 
			}
		}
	}
	
	// after a question reset the snake to a reasonable size
	public void resetSnake(GraphicsContext gc, Pane root) {
		int resetSize = snake.size()/2; 
		snake.removeAll(snake); 
		
		
		// if the snake is smaller than 6 body parts after halving just add the start snake back so the user starts back on 3 snake parts
		if(resetSize < 6) {
			addStartSnake(gc, root); 
		}
		else {
			for(int i = 0; i < resetSize; i++) {
				snake.add(new Snake(Main.BLOCK_SIZE /2, Main.BLOCK_SIZE /2, gc, root)); 
			}
		}
		
	}
	
	
	// returns the correct answer for each question
	public String getAnswer() {
		if(currentQuestion == 1) {
			
			return correctAnswer1; 
		}
		else if(currentQuestion == 2) {
			
			return correctAnswer2; 
		}
		else if(currentQuestion == 3) {
			
			return correctAnswer3; 
		}
		
		return null; 
		
		
	}
	
	
	
 	
	
}

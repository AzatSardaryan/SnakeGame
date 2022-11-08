package assigment.mvcSnake;


import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller implements EventHandler{
	
	Model model; 
	View view;
	Direction dir; 
	static int speed = 8;
	Canvas canvas; 
	
	
	
	
	
	
	public Controller(Model model, View view, Canvas canvas) {
		super();
		this.model = model;
		this.view = view;
		this.canvas = canvas; 
		this.dir = Direction.DOWN;  
		
	}
	
	
	public void startGame() {
		
		// adds an event listener to the view 
		view.scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
			
			// if the user clicks up set the direction to up only if they are not going down to stop the snake going back into itself
			// same logic applies for right, left and down key press
			if (key.getCode() == KeyCode.UP && dir!= Direction.DOWN ) {
				dir = Direction.UP;
				
			}
			else if (key.getCode() == KeyCode.LEFT  && dir!= Direction.RIGHT) {
				dir = Direction.LEFT;
			}
			else if (key.getCode() == KeyCode.RIGHT  && dir!= Direction.LEFT) {
				dir = Direction.RIGHT;
			}
			else if (key.getCode() == KeyCode.DOWN  && dir!= Direction.UP) {
				dir = Direction.DOWN;
			}

		});
		// adds the starting snake to the game and generates a new food object and starts the animation timer
		model.addStartSnake(view.gc, view.root);
		model.newFood(view.gc, view.root);
		timer.start();
	}
	

	
	



	

	

	AnimationTimer timer = new AnimationTimer() {
		long lastTick = 0; 
		@Override
		// set up of the animation timer
		public void handle(long now) {
			
			if (lastTick == 0) {
				lastTick = now;
				
				tick(); 
				
				
			}
			
			// divide by speed so as speed increases so the snake movement on the screen
			if (now - lastTick > 1000000000 / speed) {
				lastTick = now;
				tick();
			}
		
		
	}};
	
	
	public void tick() {
		
		// check to see what the game state is 
		// if current question is 4 it means game is over as there is no question 4
		if(model.isGameOver && model.currentQuestion == 4) {
			view.drawGameOver();
			return; 
		}
		
		/*
		 * depending on the currentQuestion value set the view up with the correct 
		 * display and add the handler using 'this' key word
		 * stops the timer for the snake game
		 * 
		 */
		if(model.isGameOver && model.currentQuestion ==1) {
			
			view.question1();
			view.answer1.setOnAction(this);
			view.answer2.setOnAction(this);
			view.answer3.setOnAction(this);
			view.answer4.setOnAction(this);
			
			timer.stop();
			return; 
		}
		
		if(model.isGameOver && model.currentQuestion == 2) {
			
			view.question2();
			view.answer1.setOnAction(this);
			view.answer2.setOnAction(this);
			view.answer3.setOnAction(this);
			view.answer4.setOnAction(this);
			
			timer.stop();
			return; 
		}

		if(model.isGameOver && model.currentQuestion == 3) {
	
		view.question3();
		view.answer1.setOnAction(this);
		view.answer2.setOnAction(this);
		view.answer3.setOnAction(this);
		view.answer4.setOnAction(this);
		
		timer.stop();
		return; 
}
		
		
		// shifts all body parts across by one starting from the tail to head-1
		for (int i = model.snake.size() - 1; i >= 1; i--) {
			model.snake.get(i).x = model.snake.get(i - 1).x;
			model.snake.get(i).y = model.snake.get(i - 1).y;
		}
		
		// take the dir in and depending on the value shift the head up down left or right by one
		switch(dir) {
			
		case UP: 
			model.snake.get(0).y--;
			// check to see if the snake has gone off the screen if so set is game over to true
			if(model.snake.get(0).y < 0) {
				model.isGameOver = true; 
			}
		break; 
		
		case DOWN: 
			model.snake.get(0).y++; 
			if(model.snake.get(0).y > Main.BLOCK_SIZE-1) {
				model.isGameOver = true;
			}
			break; 
			
		case LEFT:
			model.snake.get(0).x--; 
			
			if(model.snake.get(0).x < 0) {
				model.isGameOver = true;
			}
			break;
			
		case RIGHT:
			model.snake.get(0).x++; 
			if(model.snake.get(0).x > Main.BLOCK_SIZE-1) {
				model.isGameOver = true; 
			}
			break; 
	}
		
		// logic to check if the snake head has hit an apple 
		// if so increment the score and add a new snake body 
		if(model.food.x == model.snake.get(0).x && model.food.y == model.snake.get(0).y) {
			model.addSnakeBody(view.gc, view.root);
			model.score++;
			if(speed < 20) {
				// increment the speed
				speed++;
			}
			
		}
		
		
		// update the view
		view.drawSnakeGame();
		// check for head collisions 
		model.checkHeadCollision();
		
	
		
}
	
	@Override
	public void handle(Event event) {
		
		// handler for the question screen 
		
		// when the user selects an option 
		// if the text is equal to the correct answer then set game over to false
		// reset the snake
		// increment the question count 
		// and start the timer again
		// if they answer wrong draw the game over screen
		if(event.getSource() == view.answer1) {
			if(view.answer1.getText().equals(model.getAnswer())) {
				model.isGameOver = false; 
				model.resetSnake(view.gc, view.root);
				model.currentQuestion++; 
				timer.start();
			}
			else {
				view.drawGameOver();
			}
		}
		if(event.getSource() == view.answer2) {
			if(view.answer2.getText().equals(model.getAnswer())) {
				model.isGameOver = false; 
				model.currentQuestion++; 
				model.resetSnake(view.gc, view.root);
				timer.start();
			}
			else {
				view.drawGameOver();
			}
		}
		
		if(event.getSource() == view.answer3) {
			if(view.answer3.getText().equals(model.getAnswer())) {
				model.isGameOver = false; 
				model.currentQuestion++; 
				model.resetSnake(view.gc, view.root);
				timer.start();
			}
			else {
				view.drawGameOver();
			}
		}
		
		if(event.getSource() == view.answer4) {
			if(view.answer4.getText().equals(model.getAnswer())) {
				model.isGameOver = false; 
				model.currentQuestion++; 
				model.resetSnake(view.gc, view.root);
				timer.start();
			}
			else {
				view.drawGameOver();
			}
		}
		
	
		
		
	}


	
	

}

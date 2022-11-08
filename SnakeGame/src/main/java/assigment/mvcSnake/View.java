package assigment.mvcSnake;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class View {
	
	Pane root; 
	Model model; 
	Scene scene; 
	Canvas canvas; 
	GraphicsContext gc;
	Button answer1; 
	Button answer2;
	Button answer3; 
	Button answer4;
	Text t; 
	public View(Pane root, Model model, Scene scene, Canvas canvas, GraphicsContext gc) {
		super();
		this.root = root;
		this.model = model;
		this.scene = scene;
		this.canvas = canvas;
		this.gc = gc;
	} 
	
	
	
	public void drawSnakeGame() {
		root.getChildren().removeAll(answer1, answer2, answer3, answer4, t);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		drawGrid();
		model.food.update();
		drawSnake();
		drawScore(); 
	}
	
	
	public void drawGrid() {
		for(int i =0; i < Main.SCREEN_WIDTH/Main.BLOCK_SIZE; i++) {
			gc.setStroke(Color.GREY);
			gc.strokeLine(i*Main.BLOCK_SIZE, 0, i*Main.BLOCK_SIZE, Main.SCREEN_HEIGHT);
			gc.strokeLine(0, i*Main.BLOCK_SIZE, Main.SCREEN_WIDTH, i*Main.BLOCK_SIZE);
			
		}
		
	}
	
	public void drawSnake() {
		for(Snake s : model.snake) {
			
			s.update();
		}
	}
	
	public void drawGameOver() {
		root.getChildren().removeAll(answer1, answer2, answer3, answer4, t);
		
		gc.setFill(Color.RED);
		gc.setFont(new Font("", 50));
		gc.fillText("GAME OVER", 175, Main.SCREEN_HEIGHT/2.5);
		gc.fillText("Your score is:" + model.score, 175, Main.SCREEN_HEIGHT/2);
		
	}
	
	
	public void drawScore() {
		gc.setFill(Color.RED); 
		gc.setFont(new Font("", 20)); 
		gc.fillText("Score:" + model.score, 20,50);
		
	}
	
	
	public void question1() {
		 
		gc.clearRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.RED); 
		t = new Text(model.question1); 
		t.setFill(Color.RED);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		t.setLayoutX(130);
		t.setLayoutY(150);
		
		
		 answer1 = new Button(model.answers1[0]);
		 answer2 = new Button(model.answers1[1]);
		 answer3 = new Button(model.answers1[2]);
		 answer4 = new Button(model.answers1[3]);
		 answer1.setMinWidth(50);
		 answer1.setMinHeight(35);
		
		 answer2.setMinWidth(50);
		 answer2.setMinHeight(35);
		
		 answer3.setMinWidth(50);
		 answer3.setMinHeight(35);
		
		 answer4.setMinWidth(50);
		 answer4.setMinHeight(35);
		
        root.getChildren().addAll(answer1, answer2, answer3, answer4, t);

        answer1.setLayoutX(100);
        answer1.setLayoutY(400);
        
        answer2.setLayoutX(200);
        answer2.setLayoutY(400);
        
        answer3.setLayoutX(300);
        answer3.setLayoutY(400);
        
        answer4.setLayoutX(400);
        answer4.setLayoutY(400);
	
		
		}
	
	
	public void question2() {
		gc.clearRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.RED); 
		t = new Text(model.question2); 
		t.setFill(Color.RED);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		t.setLayoutX(130);
		t.setLayoutY(150);
		
		 answer1 = new Button(model.answers2[0]);
		 answer2 = new Button(model.answers2[1]);
		 answer3 = new Button(model.answers2[2]);
		 answer4 = new Button(model.answers2[3]);
		 answer1.setMinWidth(50);
		 answer1.setMinHeight(35);
		
		answer2.setMinWidth(50);
		answer2.setMinHeight(35);
		
		answer3.setMinWidth(50);
		answer3.setMinHeight(35);
		
		answer4.setMinWidth(50);
		answer4.setMinHeight(35);
		
        root.getChildren().addAll(answer1, answer2, answer3, answer4, t);

        answer1.setLayoutX(100);
        answer1.setLayoutY(400);
        
        answer2.setLayoutX(200);
        answer2.setLayoutY(400);
        
        answer3.setLayoutX(300);
        answer3.setLayoutY(400);
        
        answer4.setLayoutX(400);
        answer4.setLayoutY(400);
	}
	
	public void question3() {
		gc.clearRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		gc.setFill(Color.RED); 
		t = new Text(model.question3); 
		t.setFill(Color.RED);
		t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		t.setLayoutX(130);
		t.setLayoutY(150);
		
		 answer1 = new Button(model.answers3[0]);
		 answer2 = new Button(model.answers3[1]);
		 answer3 = new Button(model.answers3[2]);
		 answer4 = new Button(model.answers3[3]);
		answer1.setMinWidth(50);
		answer1.setMinHeight(35);
		
		answer2.setMinWidth(50);
		answer2.setMinHeight(35);
		
		answer3.setMinWidth(50);
		answer3.setMinHeight(35);
		
		answer4.setMinWidth(50);
		answer4.setMinHeight(35);
		
        root.getChildren().addAll(answer1, answer2, answer3, answer4, t);

        answer1.setLayoutX(100);
        answer1.setLayoutY(400);
        
        answer2.setLayoutX(200);
        answer2.setLayoutY(400);
        
        answer3.setLayoutX(325);
        answer3.setLayoutY(400);
        
        answer4.setLayoutX(450);
        answer4.setLayoutY(400);
	}
	
}
	
	
	
	
	
	

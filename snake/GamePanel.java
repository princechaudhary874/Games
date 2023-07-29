 package game.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 175;
	// holding the body parts of the snake
	final int[] x = new int[UNIT_SIZE];
	final int[] y = new int[UNIT_SIZE];
	// initialize the size of the snake
	int bodySize = 6;
	int appleEaten;
	// apple location
	int appleX;
	int appleY;
	// direction
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;

	GamePanel() {
		// creating instance of random
		random = new Random();
		// setting size of panel
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		newApple();
		running = true;
		// create instance of timer and pass delay and this(for keylistener)
		timer = new Timer(DELAY, this);
		// using start function
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		// to visualize the unit size in the frame ,grid is created
		for (int i = 0; i <= SCREEN_HEIGHT / UNIT_SIZE; i++) {
			// for x-axis(vertical-line)
			g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
			// for y-axis(horizontal-line);
			g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
		}
		// set color of the apple
		g.setColor(Color.RED);
		// set size and location of the apple
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
		
		//set head and body of the snake
		for(int i=0;i<bodySize;i++) {
			if(i==0) {
				g.setColor(Color.GREEN);
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
			else {
				g.setColor(new Color(45,180,0));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			}
		}
	}

	public void newApple() {
		// generates the coordinates of the apple
		appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
		appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

	}

	public void move() {
		for (int i = bodySize; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch (direction) {
		case 'U':
			y[0] -= UNIT_SIZE;
			break;
		case 'D':
			y[0] -= UNIT_SIZE;
			break;
		case 'L':
			x[0] -= UNIT_SIZE;
			break;
		case 'R':
			x[0] -= UNIT_SIZE;
			break;
		}
	}

	public void checkApple() {

	}

	public void checkCollision() {

	}

	public void gameOver(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(running) {
			move();
			checkApple();
			checkCollision();
		}
		//if game is not running 
		repaint();

	}

	// creating inner class
	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {

		}
	}
}

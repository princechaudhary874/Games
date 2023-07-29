package game.snake;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	GameFrame() {
		this.add(new GamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		//to appear the window at the middle
		this.setLocationRelativeTo(null);
	}
}

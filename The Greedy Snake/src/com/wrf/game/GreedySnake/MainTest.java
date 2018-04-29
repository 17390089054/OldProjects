package com.wrf.game.GreedySnake;

import javax.swing.JFrame;

public class MainTest extends JFrame {
	//加载JPanel
	SnakeBoard snakeBoard;
	static final int Height=600,Width=800,LX=200,LY=100;
	public MainTest()
	{
		super("Greedy Snake");
		snakeBoard=new SnakeBoard();
		this.add(snakeBoard);
		this.setSize(Width, Height);
		this.setVisible(true);
		this.setLocation(LX, LY);
		this.setDefaultCloseOperation(MainTest.EXIT_ON_CLOSE);
		snakeBoard.requestFocus();
	}
	public static void main(String[] args) {
		new MainTest();
	}

}

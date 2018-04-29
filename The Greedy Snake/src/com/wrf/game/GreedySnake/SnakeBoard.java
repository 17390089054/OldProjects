package com.wrf.game.GreedySnake;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakeBoard extends JPanel implements ActionListener ,KeyListener {
	static final int BoardX=50,BoardY=50,BoardWidth=700,BoardHeight=500,size=10;//定义画板的位置及高宽
	static final int Up=0,Down=1,Left=2,Right=3;//定义运动的方向
	private boolean startFlag=false;//定义游戏开始的标志 
	static  int fx,fy,score=0,speed=5;//定义当前速度及分数
	JButton startButton,stopButton,exitButton;
	Snake snake;
	public SnakeBoard()
	{
		snake=new Snake();
		fx=(int)(Math.random()*(BoardWidth-10)+BoardX);
		fy=(int)(Math.random()*(BoardHeight-10)+BoardY);
		//定义三个按钮
		startButton=new JButton("开始");
		stopButton=new JButton("停止");
		exitButton=new JButton("退出");
		//设置按钮的布局
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(startButton);
		this.add(stopButton);
		this.add(exitButton);
		//为按钮绑定事件
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		exitButton.addActionListener(this);
		//为当前文件添加键盘监听器
		this.addKeyListener(this);
		//启动线程
		new Thread(new SnakeThread()).start(); 
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(!startFlag) return ;
		//根据键盘值控制上下左右
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP:
				if(snake.getLength()!=1&&snake.getDir()==Down)break;
				snake.ChangeDir(Up);
				break;
			case KeyEvent.VK_DOWN:
				if(snake.getLength()!=1&&snake.getDir()==Up)break;
				snake.ChangeDir(Down);
				break;
			case KeyEvent.VK_LEFT:
				if(snake.getLength()!=1&&snake.getDir()==Right)break;
				snake.ChangeDir(Left);
				break;
			case KeyEvent.VK_RIGHT:
				if(snake.getLength()!=1&&snake.getDir()==Left)break;
				snake.ChangeDir(Right);
				break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton)
		{
			startFlag=true;
			stopButton.setEnabled(true);
			startButton.setEnabled(false);
		}
		if(e.getSource()==stopButton)
		{
			startFlag=false;
			stopButton.setEnabled(false);
			startButton.setEnabled(true);
		}
		if(e.getSource()==exitButton)
		{
			System.exit(1);
		}
		this.requestFocus();
	}
	
	//画图
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(BoardX, BoardY, BoardWidth, BoardHeight);//实心
		g.setColor(Color.BLACK);
		g.drawRect(BoardX, BoardY, BoardWidth, BoardHeight);//空心
		g.drawString("Score:"+score+"     Speed:"+speed+"   最大速度:100", 250, 25);
		g.setColor(Color.ORANGE);
		g.fillRect(fx, fy,10, 10);//食物
		snake.draw(g);
		
	}	
	//多线程
	class SnakeThread implements Runnable
	{
		@Override
		public void run() {
			while(true)
			{
				try{
				Thread.sleep(100-speed>=0?100-speed:0);
				repaint();
				if(startFlag)
				{
					snake.Move();
				}
				}catch(InterruptedException e){
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
		}
	}
}




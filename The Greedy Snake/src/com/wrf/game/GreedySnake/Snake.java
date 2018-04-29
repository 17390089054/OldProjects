package com.wrf.game.GreedySnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

class Node
{
	private int x,y;
	public Node()
	{
	}
	public Node(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public Node(Node node)
	{
		this.x=node.getX();
		this.y=node.getY();
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}

//蛇的定义
public class Snake {
	static final List<Node>list=new LinkedList<>();//定义一个链表来表示贪吃蛇  数据类型为节点类型
	private int Dir[][]={{0,-1},{0,1},{-1,0},{1,0}};//定义蛇改变的方向
	private int dir;//贪吃蛇当前运动方向
	public Snake()
	{
		dir=3;//初始化向右运动
		list.add(new Node(250,300));//任意创建一个节点
	}
	//获取运动方向
	public int getDir()
	{
		return this.dir;
	}
	//获取蛇的身长
	public int getLength()
	{
		return list.size();
	}
	
	//描绘蛇本身
	public void draw(Graphics g)
	{
		g.setColor(Color.black);
		for(int i=0;i<list.size();i++)
		{
			g.fillRect(list.get(i).getX(),list.get(i).getY(), 10,10);
		}
	}
	//判断蛇是否死亡
	public boolean  isDead()
	{
		for(int i=1;i<list.size();i++)
		{
			if(list.get(i).getX()==list.get(0).getX()&&list.get(0).getY()==list.get(i).getY())
			{
				return true;
			}
		}
		
		if(list.get(0).getX()==(SnakeBoard.BoardX)||list.get(0).getY()==SnakeBoard.BoardY)
		{
			return true;
		}
		if(list.get(0).getX()==(SnakeBoard.BoardWidth+40)||list.get(0).getY()==(SnakeBoard.BoardHeight+40))
		{
			return true;
		}
		return false;
	}
	//获取头结点
	public Node getHead()
	{
		int x=list.get(0).getX()+SnakeBoard.size*Dir[dir][0];
		int y=list.get(0).getY()+SnakeBoard.size*Dir[dir][1];
		Node head=new Node(x,y);
		return head;
	}
	
	//蛇移动
	public void Move()
	{
		//定义食物
		Node node=new Node();
		boolean hasEaten=false;
		if(Math.abs(list.get(0).getX()-SnakeBoard.fx)<10&&Math.abs(list.get(0).getY()-SnakeBoard.fy)<10)
		{
			hasEaten=true;
			node=new Node(list.get(list.size()-1));
			//设置食物出现的位置
			SnakeBoard.fx=(int)(Math.random()*(SnakeBoard.BoardWidth-10)+SnakeBoard.BoardX);
			SnakeBoard.fy=(int)(Math.random()*(SnakeBoard.BoardHeight-10)+SnakeBoard.BoardY);
		}		
		//吃完食物后 节点移动
		Node head=getHead();
		for(int i=list.size()-1;i>0;i--)
		{
			list.set(i, list.get(i-1));
		}
		list.set(0,head);
	
		if(isDead())
		{
			JOptionPane.showMessageDialog(null,"  SORRY,YOU FAILED !", "message",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		if(hasEaten)
		{
			list.add(node);
			SnakeBoard.speed++;
			SnakeBoard.score++;
		}
		
	}
	
	public void ChangeDir(int dir)
	{
		this.dir=dir;
	}
	
	
	
	
}





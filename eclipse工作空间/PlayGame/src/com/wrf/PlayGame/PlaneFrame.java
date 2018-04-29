package com.wrf.PlayGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * @package:      com.wrf.PlayGame
 * @Description:  游戏主界面     
 * @author        knight
 * @Date          2017年12月3日 下午10:33:18 
 */
public class PlaneFrame extends JFrame{
	//获取资源路径
	public static String path=System.getProperty("user.dir")+"\\Resource\\resources";
	//定义一个容器保存图片
	public static HashMap<String,BufferedImage>maps=new HashMap<>();
	//通过静态语句块（static） 将图片装入容器
	static
	{
		//读取文件
		File [] files =new File(path).listFiles();
		for(int i=0;i<files.length;i++)
		{
			try {
				//获取图片名称 图片对象
				maps.put(files[i].getName(),ImageIO.read(files[i]));
				//System.out.println("图片名称: "+files[i].getName()+"图片信息:"+ImageIO.read(files[i]));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		;
	}
	
	PlanePanle jp=null; 
	//创建一个构造方法
	public PlaneFrame()
	{
		//设置窗口大小
		this.setSize(640,700);
		//设置标题
		this.setTitle("雷霆战机");
		//设置位置居中
		this.setLocationRelativeTo(null);
		//设置窗口不可更改
		this.setResizable(false);
		//设置退出窗口时退出程序 EXIT_ON_CLOSE=3
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//将小面板添加到大面板
		jp=new PlanePanle();
		this.setContentPane(jp);
		//添加一个适配器
		this.addKeyListener(new MykeyListerner());
		//设置窗口是否可见				
		setVisible(true);
	}
	//添加适配器   控制上下左右移动
	class MykeyListerner extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent e)
		{
			jp.keyPressed(e);
		}
	}
	
	
	//创建里面的面板
	class PlanePanle extends JPanel{
		int buff=0;
		//初始化背景坐标
		Point bgPoint=new Point(0,-830);
		//初始化飞机坐标
		Point planePoint=new Point(275,500);
		
		public PlanePanle()
		{
			new Thread(new BgThread()).start();
		}
		//存储子弹坐标
		List<Point>list=new ArrayList<>(); 
		//存储敌机坐标
		List<Point>enemies=new ArrayList<>();
		
		
		
		//绘制背景图片
		@Override
		public void paint(Graphics g) {
			//调用父类的方法
			super.paint(g);
			//创建一个画板 图片颜色TYPE_INT_RGB
			BufferedImage image=new BufferedImage(640,700,BufferedImage.TYPE_INT_RGB);
			//创建一支画笔
			Graphics gs=image.createGraphics();
			//画背景
			gs.drawImage(PlaneFrame.maps.get("background1.bmp"), bgPoint.x, bgPoint.y, this);
			//一张加载完成时加载同一张 防止出现黑块
			gs.drawImage(PlaneFrame.maps.get("background1.bmp"), bgPoint.x, bgPoint.y-1530, this);
			//话飞机
			gs.drawImage(PlaneFrame.maps.get("plane.png"), planePoint.x, planePoint.y, this);
			//画子弹
			for(int i=0;i<list.size();i++)
			{
				gs.drawImage(PlaneFrame.maps.get("m3.png"),list.get(i).x, list.get(i).y, this);
			} 
			int start=0;int distance=0;
			for(int i=0;i<9;i++)
			{
				enemies.add(new Point(start,distance));
				start+=70;
				distance+=10;
			}
			
			for(int j=0;j<enemies.size();j++)
			{
				gs.drawImage(PlaneFrame.maps.get("enemy1.png"), enemies.get(j).x, enemies.get(j).y, this);
			}
			
	/*		boolean flag=true;*/
			
			
			/*int i=0;
			while(flag)
			{	
			
				gs.drawImage(PlaneFrame.maps.get("enemy1.png"),start , enemies.get(i).y, this);
				
				 System.out.println(enemies.get(i).x+" "+enemies.get(i).y);
				i++;
				start+=70;
				if(start==630)
					flag=false;
				
			}*/
			System.out.println(enemies.size());
		
		
			
			//将画板添加到JPanel
			g.drawImage(image, 0, 0, this);
			
		}	
		
		//定义多线程来实现图片的移动
				class BgThread implements Runnable
				{
						@Override
						public void run()
						{
							while(true)
							{
								//如果到了最下面
								if(bgPoint.y==700)
								{
									bgPoint.y=-830;
								}
								bgPoint.y+=1;
								//让子弹飞
									for(int i=0;i<list.size();i++)
									{
										list.get(i).y-=10;
									}
									
								enemyMove();
								
								//线程休眠
								try {
									Thread.sleep(30);
								} catch (InterruptedException e) {
								
									e.printStackTrace();
								}
								//更新
								repaint();
							}
							
							
						}
				}
				
				
				
				void enemyMove()
				{
					//敌机出现
					for(int i=0;i<enemies.size();i++)
					{
						enemies.get(i).y+=1; 
						if(i>0)
						{
							enemies.remove(enemies.get(i-1));
						}
											
					}
					
				}
				
				
				//键盘触发 操作上下左右移动
				public void keyPressed(KeyEvent e)
				{
					//发射
					if(e.getKeyCode()==KeyEvent.VK_SPACE)
					{
						fire();
					}
					//上键
					if(e.getKeyCode()==KeyEvent.VK_UP)
					{
						planePoint.y-=10;
					}
					
					//下键
					if(e.getKeyCode()==KeyEvent.VK_DOWN)
					{
						planePoint.y+=10;
					}
					
					//左键
					if(e.getKeyCode()==KeyEvent.VK_LEFT)
					{
						planePoint.x-=10;
					}
					
					//右键
					if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					{
						planePoint.x+=10;
					}
					//s刷新
					repaint();
				}
						
				public void fire()
				{
					if(buff==0)
					{
						list.add(new Point(planePoint.x+25,planePoint.y-80));
						buff=1;
					}
					else
					{
						list.add(new Point(planePoint.x-15,planePoint.y-80));
						buff=0;
					}
				}
				
	}
	
	
	
	//主函数 java程序的入口
	public static void main(String[] args) {
		System.out.println(path);
		PlaneFrame pf=new PlaneFrame();
		
	}

}

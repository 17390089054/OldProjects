package com.wrf.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @Description:本地监控核心类
 * @ClassName LocalScreen 
 * @date 2018年1月24日
 * @author knight<br/>
 * <a href="http://www.baidu.com/">百度一下</a>
 */
public class LocalScreen {
	public static void main(String[] args)  {
		//询问框
		int choice=JOptionPane.showConfirmDialog(null, "请求控制对方电脑","汪荣福",JOptionPane.YES_NO_CANCEL_OPTION);
		//判断按钮的类型
		if(choice==JOptionPane.NO_OPTION||choice==JOptionPane.CANCEL_OPTION)
		{
			return;
		}
		//输入IP地址和端口号
		JOptionPane.showInputDialog("请输入你要连接的服务器的IP地址和服务器端口号:","127.0.0.1:10000");
		//初始化一个窗口
		JFrame jFrame=new JFrame("远程桌面");  
		//设置窗口大小
		jFrame.setSize(600, 600);
		//设置窗口是否可见
		jFrame.setVisible(true);
		//窗口居中显示
		jFrame.setLocationRelativeTo(null);
		//窗口保持置顶
		jFrame.setAlwaysOnTop(true);
		//点击关闭按钮结束程序
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel imageLabel=new JLabel(); 
		//图片放入JFrame
		jFrame.add(imageLabel);
		//监控本地桌面
		try{
		//创建一个机器人
		Robot robot=new Robot();
		//获取屏幕大小
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		//System.out.println("宽度:"+dm.getWidth()+"高度:"+dm.getHeight()+" ");
		while(true)
		{
		//指定分享的区域
		Rectangle rectangle=new Rectangle(0,0,(int)dm.getWidth()-jFrame.getWidth(),(int)dm.getHeight());
		//利用机器人截取一张图片
		 BufferedImage bufImg=robot.createScreenCapture(rectangle); 
		//图片放入imageJLabel
		 imageLabel.setIcon(new ImageIcon(bufImg));
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	 
	
		
}

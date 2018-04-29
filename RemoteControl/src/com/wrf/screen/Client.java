package com.wrf.screen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @ClassName Client
 * @description 远程桌面监控客户端
 * @author knight
 * @date  2018年1月24日

 */
public class Client {
		public static void main(String[] args) {
			//询问对话框
			int choice=JOptionPane.showConfirmDialog(null, "请求控制对方电脑","汪荣福",JOptionPane.YES_NO_CANCEL_OPTION);
			//判断点击按钮
			if(choice==JOptionPane.CANCEL_OPTION||choice==JOptionPane.NO_OPTION)
			{
				return;
			}
			try {
				//获取服务器的主机
				String input=JOptionPane.showInputDialog("请输入您要连接的服务器的IP地址和端口号","127.0.0.1:10000");
				//获取服务器的主机		
				String host = input.substring(0,input.indexOf(":"));
				//获取端口号
				int post = Integer.parseInt(input.substring(input.indexOf(":")+1));
				//连接服务器
				Socket client=new Socket(host,post);
				//输入流
				DataInputStream dis=new DataInputStream(client.getInputStream());
				
				//创建显示面板
				JFrame jFrame=new JFrame();
				//点击关闭按钮退出程序
				jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
				jFrame.setTitle("远程桌面控制-汪荣福");
				
				//读取服务器分辨率
				double height=dis.readDouble();
				double width=dis.readDouble();
				System.out.println("服务器宽度:"+width+"服务器高度:"+height);
				Dimension ds=new Dimension((int)width,(int)height);
				jFrame.setSize(ds);
				//面板
				JLabel backImage=new JLabel();
				JPanel panel=new JPanel();
				//设置滚动条
				JScrollPane scrollPane=new JScrollPane(panel);
				panel.setLayout(new FlowLayout());
				panel.add(backImage);
				jFrame.add(scrollPane);
				
				jFrame.setVisible(true);//设置窗口是否可见
				jFrame.setLocationRelativeTo(null);//设置窗口居中
				jFrame.setAlwaysOnTop(true);//设置窗口居顶

				while(true)
				{
					//获取流的长度
					int length=dis.readInt();
					byte[] imageData=new byte[length];
					dis.readFully(imageData);
					
					ImageIcon image=new ImageIcon(imageData);
					backImage.setIcon(image);
					//重新绘制面板
					jFrame.repaint();
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
}



package com.wrf.jump;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

/** 
 * @package:        com.wrf.jump
 * @Description:  TODO(这里用一句话描述这个方法的作用) 
 * @author        knight
 * @Date          2018年3月12日 下午9:15:44 
 */
public class Jump extends JFrame{
	boolean flag=true;
	int x0,y0,x1,y1;
	public Jump(){
		super("微信跳一跳");
		this.setSize(310,640);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置居顶
		this.setAlwaysOnTop(true);
		//去除边框
		this.setUndecorated(true);
		//设置透明度
		this.setOpacity(0.4f);
		//设置居中
		this.setLocationRelativeTo(null);
		//设置可见
		this.setVisible(true);
		//添加标签
		JLabel label =new JLabel();
		this.add(label);
		//添加鼠标点击事件
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//鼠标左键点击
				if(e.getButton()==MouseEvent.BUTTON1){
					if(flag){//第一次点击
						x0=e.getX();
						y0=e.getY();
						System.out.println("第一次点击坐标:x0:"+x0+" y0:"+y0);
						flag=false;
					}else{//第二次点击
						x1=e.getX();
						y1=e.getY();
						System.out.println("第二次点击坐标:x1:"+x1+" y1:"+y1);
						//计算距离
						double _x=Math.abs(x0-x1);
						double _y=Math.abs(y0-y1);
						double distance = Math.sqrt(_x*_x+_y*_y);
						String cmd="adb shell input touchscreen swipe 150 150 150 180 "+Math.round(distance*5);
						Runtime runtime=Runtime.getRuntime();
						try {
							Process par = runtime.exec(cmd);
							par.waitFor();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						flag=true;
					}
			}
			}
		});
		
		
	}
	public static void main(String[] args) {
		new Jump();
	}
	
	
	
}

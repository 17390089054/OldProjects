package com.wrf.jump;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

/** 
 * @package:        com.wrf.jump
 * @Description:  TODO(������һ�仰�����������������) 
 * @author        knight
 * @Date          2018��3��12�� ����9:15:44 
 */
public class Jump extends JFrame{
	boolean flag=true;
	int x0,y0,x1,y1;
	public Jump(){
		super("΢����һ��");
		this.setSize(310,640);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���þӶ�
		this.setAlwaysOnTop(true);
		//ȥ���߿�
		this.setUndecorated(true);
		//����͸����
		this.setOpacity(0.4f);
		//���þ���
		this.setLocationRelativeTo(null);
		//���ÿɼ�
		this.setVisible(true);
		//��ӱ�ǩ
		JLabel label =new JLabel();
		this.add(label);
		//���������¼�
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//���������
				if(e.getButton()==MouseEvent.BUTTON1){
					if(flag){//��һ�ε��
						x0=e.getX();
						y0=e.getY();
						System.out.println("��һ�ε������:x0:"+x0+" y0:"+y0);
						flag=false;
					}else{//�ڶ��ε��
						x1=e.getX();
						y1=e.getY();
						System.out.println("�ڶ��ε������:x1:"+x1+" y1:"+y1);
						//�������
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

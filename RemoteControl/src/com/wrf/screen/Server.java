package com.wrf.screen;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @ClassName Server
 * @description 远程桌面监控服务类
 * @author knight
 * @date  2018年1月24日
 */

public class Server {
@SuppressWarnings("resource")
public static void main(String[] args) {
	
	//建立服务器的监听
	try {
		ServerSocket ss = new ServerSocket(10000);
		System.out.println("正在连接服务器........");;
		Socket client=ss.accept();
		System.out.println("连接成功!");
		OutputStream os=client.getOutputStream();
		//文件流转换为二进制数据
		DataOutputStream doc=new DataOutputStream(os);
		
		//启动线程
		ScreenThread screenThread=new ScreenThread(doc);
		screenThread.start();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
}

//定义多线程
class ScreenThread extends Thread{
	//数据输出流
	private DataOutputStream dataout;
	public ScreenThread(DataOutputStream dataout){
		this.dataout=dataout;
		
	}
	//开始启动线程
	
	public void run(){  
		//定义方法获取屏幕大小
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		
		try {
			//获取屏幕的分辨率
			dataout.writeDouble(dm.getWidth());
			dataout.writeDouble(dm.getHeight());
			//刷新
			dataout.flush();
			
			//定义分享屏幕区域的大小
			Rectangle rc=new Rectangle(dm);
			Robot robot=new Robot();
			while(true)
			{
				//解析图片
				BufferedImage bufferedImage=robot.createScreenCapture(rc);
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				//图片压缩处理
				JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(baos);
				encoder.encode(bufferedImage);
				//字节流传输的文件流
				byte[] data=baos.toByteArray();
				dataout.writeInt(data.length);
				dataout.write(data);
				dataout.flush();
				Thread.sleep(0);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
}

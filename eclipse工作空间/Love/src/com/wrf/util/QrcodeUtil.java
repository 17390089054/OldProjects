package com.wrf.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/** 
 * @package:      com.wrf.util
 * @Description:  TODO(二维码生成类) 
 * @author        knight
 * @Date          2018年2月5日 下午9:06:52 <br/>
 *PS:  <a href="http://blog.csdn.net/wo240/article/details/52615276">Qrcode使用说明</a>
 */
public class QrcodeUtil {
	
	public static void QrcodeImg(String content,String imgPath){
		
		//实例化一个Qrcode对象
		Qrcode qrcode=new Qrcode();
		//设置二维码的排错率 15%空间存放错误信息 排错率越高可存储的信息越少
		qrcode.setQrcodeErrorCorrect('M');
		//编码
		qrcode.setQrcodeEncodeMode('B');
		//版本
		qrcode.setQrcodeVersion(7);
		
		int width=140;
		int height=140;
		//绘制----画板
		BufferedImage bf=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//绘制工具
		Graphics2D gs=bf.createGraphics();
		//设置背景色
		gs.setBackground(Color.white);
		//设置绘制区域
		gs.clearRect(0,0,width,height);
		//设置画笔的颜色
		gs.setColor(Color.black);
		
		try {
			//正式绘制 根据内容绘制
			byte[] contentByte = content.getBytes("utf-8");
			//二维数组
			boolean [][]codeOut=qrcode.calQrcode(contentByte);
			//判断二维码内容
			for(int i=0;i<codeOut.length;i++){
				for(int j=0;j<codeOut.length;j++){
					if(codeOut[j][i]){
						gs.fillRect(j*3+2, i*3+2, 3, 3);
					}
				}
			}
			gs.dispose();
			//文件输出
			File imageFile=new File(imgPath);
			ImageIO.write(bf, "png", imageFile);
			System.out.println("二维码已生成 快去看看吧!");
			System.out.println("地址:"+imgPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
}

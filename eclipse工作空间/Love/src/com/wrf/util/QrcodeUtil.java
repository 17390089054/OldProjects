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
 * @Description:  TODO(��ά��������) 
 * @author        knight
 * @Date          2018��2��5�� ����9:06:52 <br/>
 *PS:  <a href="http://blog.csdn.net/wo240/article/details/52615276">Qrcodeʹ��˵��</a>
 */
public class QrcodeUtil {
	
	public static void QrcodeImg(String content,String imgPath){
		
		//ʵ����һ��Qrcode����
		Qrcode qrcode=new Qrcode();
		//���ö�ά����Ŵ��� 15%�ռ��Ŵ�����Ϣ �Ŵ���Խ�߿ɴ洢����ϢԽ��
		qrcode.setQrcodeErrorCorrect('M');
		//����
		qrcode.setQrcodeEncodeMode('B');
		//�汾
		qrcode.setQrcodeVersion(7);
		
		int width=140;
		int height=140;
		//����----����
		BufferedImage bf=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
		//���ƹ���
		Graphics2D gs=bf.createGraphics();
		//���ñ���ɫ
		gs.setBackground(Color.white);
		//���û�������
		gs.clearRect(0,0,width,height);
		//���û��ʵ���ɫ
		gs.setColor(Color.black);
		
		try {
			//��ʽ���� �������ݻ���
			byte[] contentByte = content.getBytes("utf-8");
			//��ά����
			boolean [][]codeOut=qrcode.calQrcode(contentByte);
			//�ж϶�ά������
			for(int i=0;i<codeOut.length;i++){
				for(int j=0;j<codeOut.length;j++){
					if(codeOut[j][i]){
						gs.fillRect(j*3+2, i*3+2, 3, 3);
					}
				}
			}
			gs.dispose();
			//�ļ����
			File imageFile=new File(imgPath);
			ImageIO.write(bf, "png", imageFile);
			System.out.println("��ά�������� ��ȥ������!");
			System.out.println("��ַ:"+imgPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}
	
}

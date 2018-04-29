package com.wrf.util;
/** 
 * @package:        com.wrf.util
 * @Description:  TODO(������һ�仰�����������������) 
 * @author        knight
 * @Date          2018��2��6�� ����10:22:21 
 */

import java.awt.image.BufferedImage;
public class TwoDimensionCodeImage implements QRCodeImage {

	BufferedImage bufImg;

	public TwoDimensionCodeImage(BufferedImage bufImg) {
		this.bufImg = bufImg;
	}

	@Override
	public int getHeight() {
			return bufImg.getHeight();
	}

	@Override
	public int getPixel(int x, int y) {
			return bufImg.getRGB(x, y);
	}

	@Override
	public int getWidth() {
			return bufImg.getWidth();
	}

}
package com.wrf.util;
/** 
 * @package:        com.wrf.util
 * @Description:  TODO(这里用一句话描述这个方法的作用) 
 * @author        knight
 * @Date          2018年2月6日 上午10:22:21 
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
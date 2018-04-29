package com.wrf.util;
/** 
 * @package:        com.wrf.util
 * @Description:  TODO(二维码图像接口) 
 * @author        knight
 * @Date          2018年2月6日 上午10:27:23 
 */
public interface QRCodeImage {
	public int getHeight();
	public int getPixel(int x, int y);
	public int getWidth();
}

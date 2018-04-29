package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.Validate;
/** 
 * @package:        utils
 * @Description:  TODO(这里用一句话描述这个方法的作用) 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年11月4日 下午2:08:34 
 */
public class EncryptUtil {
	
		public static final String DEFAULT_URL_ENCODING="UTF-8";
		public static final String SHA1="SHA-1";
		public static final String MD5="MD5";
		
		private static SecureRandom random=new SecureRandom();
		/**
		 * 生成随机的Byte[]作为salt
		 * @param numBytes
		 * @return
		 */
		public static byte[] generateSalt(int numBytes)
		{
			Validate.isTrue(numBytes>0,"numBytes argument must be an integer",numBytes); 
			 byte [] bytes=new byte[numBytes];
			 random.nextBytes(bytes);
			return bytes   ;
			
		} 
		/*
		 * Hex编码
		 */
		public static String encodeHex(byte[] salt)
		{
			return new String (Hex.encodeHex(salt));
		}
		/*
		 * Hex解码
		 */
		public static byte[] decodeHex(String input)
		{
			try
			{
				return Hex.decodeHex(input.toCharArray());

			}catch(DecoderException e)
			{
				e.printStackTrace();
			}		
			return null;
		}
		
		
		public static byte[] sha1(byte [] plain,byte [] salt,int time)
		{
			String result="";
			byte [] data=(salt.toString()+plain.toString()).getBytes();
			for(int i=0;i<time;i++)
			{
				result=DigestUtils.sha1Hex(data);
				break;
			}
			
			return result.getBytes();
		}
		/**
		 * SHA1加密算法
		 * @param str
		 * @return
		 */
		public static String getSha1(String str){
		    if (null == str || 0 == str.length()){
		        return null;
		    }
		    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
		            'a', 'b', 'c', 'd', 'e', 'f'};
		    char[] buf=null;
		    try {
		        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
		        mdTemp.update(str.getBytes("UTF-8"));
		         
		        byte[] md = mdTemp.digest();
		        int j = md.length;
		        buf= new char[j * 2];
		        int k = 0;
		        for (int i = 0; i < j; i++) {
		            byte byte0 = md[i];
		            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
		            buf[k++] = hexDigits[byte0 & 0xf];
		        }
		      
		    } catch (NoSuchAlgorithmException e) {
		        e.printStackTrace();
		    } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		    }
		    return new String(buf);
		}
	
		
}

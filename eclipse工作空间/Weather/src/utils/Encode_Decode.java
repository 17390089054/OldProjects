package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * @package:        utils
 * @Description:    PBKDGF2加密算法 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年11月4日 下午1:40:17 
 */
/*
 * 密码加密
 */
public class Encode_Decode {
	/*
	 * 1.生成随机盐
	 * 2.将随机盐进行可逆加密(HEX)
	 * 3.将随机盐和明文密码进行不可逆加密(SHA1)
	 * 4.将第三步的结果进行可逆加密(HEX)
	 * 5.将加密后的随机盐和第四步拼接
	 */
	public static String encode(String plain)
	{
		//生成随机盐
		byte[] salt=EncryptUtil.generateSalt(8);
		//2.用可逆的加密算法进行加密(HEX)
		String encodeSalt=EncryptUtil.encodeHex(salt);
		//3.将随机盐和明文密码进行不可逆加密(SHA1)
		byte[]sha1=EncryptUtil.sha1(plain.getBytes(),salt,1024);
		//4.将第三步的结果进行可逆加密(HEX)
		String cipherText=EncryptUtil.encodeHex(sha1);
		 //5.将加密后的随机盐和第四步加密
		String finalCiper=encodeSalt+cipherText;
		
		
		
		return finalCiper;
	}
	
	/**
	 * 密码校验
	 * @return
	 */
	public static boolean decode(String plain,String cipher)
	{
		boolean flag=false;
		//1.截取随机盐
		String saltHex=cipher.substring(0,16);
		//2.解密随机盐
		byte[] decodeHex=EncryptUtil.decodeHex(saltHex);
		//3.将盐和明文进行不可逆加密(SHA1)
		byte [] sha1=EncryptUtil.sha1(plain.getBytes(), decodeHex, 1024);
		//4.对第三步的结果进行可逆加密(HEX)
		String encodeHex=EncryptUtil.encodeHex(sha1); 
		//5.拼接第一步和第四步的结果
		String finnalCiper=saltHex+encodeHex;
		if(finnalCiper.equals(cipher))
		{
			flag=true;
		}
		
	return flag;	
	}
	
	
	
	public static void main(String[] args) {
		String code="123456";
		String result=encode(code);
		
		System.out.println(result);
	}

}

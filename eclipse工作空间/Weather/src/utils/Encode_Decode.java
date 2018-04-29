package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * @package:        utils
 * @Description:    PBKDGF2�����㷨 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��11��4�� ����1:40:17 
 */
/*
 * �������
 */
public class Encode_Decode {
	/*
	 * 1.���������
	 * 2.������ν��п������(HEX)
	 * 3.������κ�����������в��������(SHA1)
	 * 4.���������Ľ�����п������(HEX)
	 * 5.�����ܺ������κ͵��Ĳ�ƴ��
	 */
	public static String encode(String plain)
	{
		//���������
		byte[] salt=EncryptUtil.generateSalt(8);
		//2.�ÿ���ļ����㷨���м���(HEX)
		String encodeSalt=EncryptUtil.encodeHex(salt);
		//3.������κ�����������в��������(SHA1)
		byte[]sha1=EncryptUtil.sha1(plain.getBytes(),salt,1024);
		//4.���������Ľ�����п������(HEX)
		String cipherText=EncryptUtil.encodeHex(sha1);
		 //5.�����ܺ������κ͵��Ĳ�����
		String finalCiper=encodeSalt+cipherText;
		
		
		
		return finalCiper;
	}
	
	/**
	 * ����У��
	 * @return
	 */
	public static boolean decode(String plain,String cipher)
	{
		boolean flag=false;
		//1.��ȡ�����
		String saltHex=cipher.substring(0,16);
		//2.���������
		byte[] decodeHex=EncryptUtil.decodeHex(saltHex);
		//3.���κ����Ľ��в��������(SHA1)
		byte [] sha1=EncryptUtil.sha1(plain.getBytes(), decodeHex, 1024);
		//4.�Ե������Ľ�����п������(HEX)
		String encodeHex=EncryptUtil.encodeHex(sha1); 
		//5.ƴ�ӵ�һ���͵��Ĳ��Ľ��
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

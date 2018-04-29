package com.wrf.learning;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.IOPdemo.sysmanage.utils.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �û���¼������
 * @author knight
 *
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private final static String matchUrl="https://aip.baidubce.com/rest/2.0/face/v2/match";
	private  static String accessToken="";
	static{
		//accessToken=GetToken.getToken("","");��ȡaccessKey ͨ��accountID ��password 
		
	}
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	req.setCharacterEncoding("utf-8");
	//��ȡҳ���沿��Ϣ
	String userBase=req.getParameter("imageBase64");
	//��ȡ���ݿ���沿��Ϣ����ƥ��
	getResult(userBase);
	
}
	public static boolean getResult(String userBase)
	{
		boolean flag=false;
		String DbBase64="";
		//DbBase64=DbUtil.getBase64ById("sql���");
		
		try
		{
			String params=URLEncoder.encode("image","UTF-8")+"="
			+URLEncoder.encode(userBase+","+DbBase64,"UTF-8");
			String result="";
			result=HttpUtil.post(matchUrl,accessToken,params);
			JSONObject fromObject=JSONObject.fromObject(result);
			JSONArray jsonArray=fromObject.getJSONArray("result");
			for(int i=0;i<jsonArray.size();i++)
			{
				JSONObject object=(JSONObject)jsonArray.get(i);
				double d=object.getDouble("score");
				if(d>=90)
				{
					flag=true;
				}
				
				
			}
			
			
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
}

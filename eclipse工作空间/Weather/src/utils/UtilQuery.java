package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;
/** 
 * @package:        utils
 * @Description:  TODO(������һ�仰�����������������) 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017��11��1�� ����12:19:10 
 */
public class UtilQuery{
	
	public static String OpenUrl(String path,Map<String,String>args,String method){
		//�����ѯ����������
		StringBuilder  sb=new StringBuilder();
		BufferedReader bf=null;
		if("".equals(path)||path==null)
		{
			sb.append("��ѯ���в���Ϊ��");	
		}		
		else
		{
			if(path.equalsIgnoreCase("post"))
			{
				try {
					URL url=new URL(path);
					HttpURLConnection uc=(HttpURLConnection) url.openConnection();
					//��������ʽ
					uc.setRequestMethod("POST");
					//�����Ƿ���������д��
					uc.setDoInput(true);
					//�����Ƿ��������ݶ�ȡ
					uc.setDoOutput(true);
					//������Ӧʱ��
					uc.setConnectTimeout(15000);
					uc.setReadTimeout(10000);
					OutputStreamWriter out=new OutputStreamWriter(uc.getOutputStream(),"utf-8");
					//��ȡmap�еĲ���
					String query=""; 
					if(args!=null)
					{
						for(Entry<String, String> entry:args.entrySet())
						{
							query+=entry.getKey()+"="+entry.getValue()+"&";
							
						}
					}				
					
					out.write(query);
					//ˢ�������
					out.flush();
					//��ȡ����
					bf=new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
					String line="";
					while((line=bf.readLine())!=null)
					{
						sb.append(line+"\n");
					}
				
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				finally
				{
				if(bf!=null)
				{
					try {
						bf.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
			}
			}
		
			else
			{
				try {
					
					String query="?"; 
					if(args!=null)
					{
						for(Entry<String, String> entry:args.entrySet())
						{
							query+=entry.getKey()+"="+entry.getValue()+"&";
							
						}
					}		
					URL url=new URL(path+query);
					 URLConnection uc=url.openConnection();
					 InputStreamReader input=new InputStreamReader(uc.getInputStream(),"utf-8");
					 bf=new BufferedReader(input);
					 String line="";
					 while((line=bf.readLine())!=null)
					 {
						 sb.append(line);
					 }
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				finally
				{
				if(bf!=null)
				{
					try {
						bf.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
					
				}
				
			}
			
			
		
		
	}
		return sb.toString();		
	}	
}

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
 * @Description:  TODO(这里用一句话描述这个方法的作用) 
 * @param:       
 * @return:      
 * @throws 
 * @author        knight
 * @Date          2017年11月1日 上午12:19:10 
 */
public class UtilQuery{
	
	public static String OpenUrl(String path,Map<String,String>args,String method){
		//定义查询天气的容器
		StringBuilder  sb=new StringBuilder();
		BufferedReader bf=null;
		if("".equals(path)||path==null)
		{
			sb.append("查询城市不能为空");	
		}		
		else
		{
			if(path.equalsIgnoreCase("post"))
			{
				try {
					URL url=new URL(path);
					HttpURLConnection uc=(HttpURLConnection) url.openConnection();
					//设置请求方式
					uc.setRequestMethod("POST");
					//设置是否允许数据写入
					uc.setDoInput(true);
					//设置是否允许数据读取
					uc.setDoOutput(true);
					//设置响应时间
					uc.setConnectTimeout(15000);
					uc.setReadTimeout(10000);
					OutputStreamWriter out=new OutputStreamWriter(uc.getOutputStream(),"utf-8");
					//读取map中的参数
					String query=""; 
					if(args!=null)
					{
						for(Entry<String, String> entry:args.entrySet())
						{
							query+=entry.getKey()+"="+entry.getValue()+"&";
							
						}
					}				
					
					out.write(query);
					//刷新输出流
					out.flush();
					//读取数据
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

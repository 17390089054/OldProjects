package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import entity.User;

/** 
 * @package:        util
 * @Description:  TODO(数据库工具类) 
 * @author        knight
 * @Date          2018年2月7日 下午5:38:56 
 */
public class DbUtil {
	private static  String driver;
	private static  String url;
	private static  String username;
	private static  String password; 
	
	static{
		loadConfig();		
	}
	/**
	 * 读取配置文件
	 */
	private  static void loadConfig(){
		InputStream inStream = DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		try {
			properties.load(inStream);
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	Connection connection=null;
	/**
	 * 获取连接
	 */
	private void getConnection(){
		try {				
			 connection=DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	
	/**
	 * 插入操作类
	 * @param user
	 * @return flag 执行状态
	 */
	public boolean insert(User user){
		boolean flag=false;
		//获取连接
		PreparedStatement ps=null;
		getConnection();
		String sql="insert into user (phone,gender,apply_id,apply_key,open_id) values(?,?,?,?,?)";
		try {
			ps= connection.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			//判断性别
			int sex=user.getGender().equals("男")?0:1;
			ps.setInt(2, sex);
			ps.setString(3, user.getApplyId());
			ps.setString(4, user.getApplyKey());
			ps.setString(5, user.getOpenId());
			int raw = ps.executeUpdate();
			if(raw>0){
				flag=true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close(connection,ps,null);
		}
		
	
		return flag;
	}
	

	/**
	 * 查询单条记录
	 * @param openId
	 * @return List<User>集合
	 */
	
	public User Query(String openId){
		User user=new User();
		ResultSet rs=null;
		PreparedStatement ps=null;
		getConnection();
		//定义返回的集合
		String sql="select * from user where open_id=?";
		try {
			 ps=connection.prepareStatement(sql);
			 ps.setString(1, openId);
			 rs= ps.executeQuery();
			 //获取结构化数据对象
			 ResultSetMetaData data = rs.getMetaData();
			 //获取列数
			 int columnCount = data.getColumnCount();
			//循环遍历rs
			 while(rs.next()){
				 for(int i=0;i<columnCount;i++){
					 	int id=rs.getInt("id");
					 	int gender=rs.getInt("gender");
					 	String phone=rs.getString("phone");
					 	String apply_id = rs.getString("apply_id");
					 	String apply_key = rs.getString("apply_key");
					 	String open_id=rs.getString("open_id");
					 	user.setId(id);
					 	String sex=gender==0?"男":"女";
					 	user.setGender(sex);
					 	user.setApplyId(apply_id);
					 	user.setApplyKey(apply_key);
					 	user.setOpenId(open_id);
					 	
				 }
				 
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close(connection,ps,rs);
		}
		
		return user;
	}
	/**
	 * 查询所有记录
	 * @return List<User>
	 */
	public List<User>Query(){
		ResultSet rs=null;
		PreparedStatement ps=null;
		getConnection();
		//定义返回的集合
		List<User>list=new ArrayList<>();
		String sql="select * from user";
		try {
			 ps=connection.prepareStatement(sql);
			
			 rs= ps.executeQuery();
			 //获取结构化数据对象
			 ResultSetMetaData data = rs.getMetaData();
			 //获取列数
			 int columnCount = data.getColumnCount();
			//循环遍历rs
			 while(rs.next()){
				 User user=new User();
				 for(int i=0;i<columnCount;i++){
					 	int id=rs.getInt("id");
					 	int gender=rs.getInt("gender");
					 	String phone=rs.getString("phone");
					 	String apply_id = rs.getString("apply_id");
					 	String apply_key = rs.getString("apply_key");
					 	String open_id=rs.getString("open_id");
					 	user.setId(id);
					 	String sex=gender==0?"男":"女";
					 	user.setGender(sex);
					 	user.setApplyId(apply_id);
					 	user.setApplyKey(apply_key);
					 	user.setOpenId(open_id);
					 	
				 }
				 
				 list.add(user);
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.close(connection,ps,rs);
		}
		
		return list;
	}
	
	public void close(Connection connection,PreparedStatement ps,ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	System.out.println(new DbUtil().Query("dfs"));
	}
	
	
	
	
	

}

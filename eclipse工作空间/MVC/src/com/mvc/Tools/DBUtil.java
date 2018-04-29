package com.mvc.Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：数据库工具类
 * 
 * @author 于升 2017年10月20日
 *
 */
public class DBUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver"; // mysql驱动
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/mvc?characterEncoding=utf-8"; // mysql
																				// url
	private static final String USER = "root"; // 数据库用户名
	private static final String PASSWORD = "admin"; // 数据库密码
	private static Connection conn = null;

	//静态代码块 类加载的时候被执行
	static {
		try {
			// 1.加载驱动
			Class.forName(DRIVER);
			System.out.println("=======加载驱动成功=========");
		} catch (ClassNotFoundException e) {
			System.out.println("DBUtil加载驱动失败:" + e.getMessage());
		}
	}

	// 2.获取连接
	private static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			System.out.println("DBUtil工具类-->获取连接失败,原因为:" + e.getMessage());
		}
		return null;
	}

	/**
	 * 多个问号，使用预处理方式进行添加/修改/和删除操作
	 * 
	 * @param sql
	 *            预处理方式
	 * @param args
	 *            传递的参数
	 * @return
	 */
	//用参数中的Object存储全部的数据  用来替换掉语句中的？
	public static int executeUpdate(String sql, Object[] args) {
		//创建预处理语句对象
		PreparedStatement ps = null;
		//对链接对象赋值
		conn = getConnection();
		try {
			//通过链接对象获取预编译语句对象编译sql
			ps = conn.prepareStatement(sql);
			// 判断参数args中是否包含数据
			if (args != null && args.length > 0) {
				//将参数中数组的全部数据拆分
				for (int i = 0; i < args.length; i++) {
					//将参数数组中的全部数据拆分并替换到sql中的问号
					ps.setObject(i + 1, args[i]);
				}
			}
			//执行语句并返回结果
			return ps.executeUpdate();
		} catch (SQLException e) {
			//打印错误信息
			System.out.println("===sql执行时出现了异常！===");
			e.printStackTrace();
		} finally {
			//关闭方法 按照顺序关闭链接对象 语句对象  因为没有使用到结果集对象  所以直接传null
			close(conn, ps, null);
		}
		//当语句执行失败  返回参数-1
		return -1;
	}

	/**
	 * 一个问号，使用预处理方式进行添加/修改/和删除操作
	 * 
	 * @param sql
	 *            预处理方式有一个问号
	 * @param arg
	 *            参数
	 * @return
	 */
	public static int executeUpdate(String sql, Object arg) {
		//因为当前方法是处理一个问号的  所以直接调用多个问号的方法  然后只传递一个值就可以了
		return executeUpdate(sql, new Object[] { arg });
	}

	/**
	 * 没有问号，使用预处理方式进行添加/修改/和删除操作
	 * 
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		//调用当前类中的其他方法  处理不需要替换问号的
		return executeUpdate(sql, null);
	}

	// 结果集封装list
	public static List<Map<String, Object>> list(String sql, Object[] args) {
		//创建预处理语句对象
		PreparedStatement ps = null;
		//创建结果集对象
		ResultSet rs = null;
		//将链接对象赋值
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql); // 预编译语句对象
			// 判断参数args中是否包含数据
			if (args != null && args.length > 0) {
				//将参数中数组的全部数据拆分
				for (int i = 0; i < args.length; i++) {
					//将参数数组中的全部数据拆分并替换到sql中的问号
					ps.setObject(i + 1, args[i]);
				}
			}
			//执行语句 得到结果集
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = ps.getMetaData();// 获取数据结构
			// 获得结果集列数
			int columnCount = rsmd.getColumnCount();// 获取列数
			// 构造泛型结果集
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
			// 循环结果集
			while (rs.next()) {
				//创建map对象 将查询出的每一条存储到map
				Map<String, Object> map = new HashMap<String, Object>();
				//通过循环获取每条数据的每一个字段
				for (int i = 1; i <= columnCount; i++) {
					//查询出来的字段都是小写
					String k = rsmd.getColumnLabel(i);
					//获取value值
					Object v = rs.getObject(k);
					//存到map中
					map.put(k, v);
				}
				//将每一条数据存入list
				dataList.add(map);
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//关闭方法 按照顺序关闭链接对象 语句对象  因为没有使用到结果集对象
			close(conn, ps, rs);
		}

	}

	public static List<Map<String, Object>> list(String sql, Object arg) {
		return list(sql, new Object[] { arg });
	}

	public static List<Map<String, Object>> list(String sql) {
		return list(sql, null);
	}

	public static Map<String, Object> query(String sql, Object[] args) {
		//创建预处理语句对象
		PreparedStatement ps = null;
		//创建结果集对象
		ResultSet rs = null;
		//将链接对象赋值
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql); // 预编译语句对象
			// 判断
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}

			rs = ps.executeQuery();

			ResultSetMetaData rsmd = ps.getMetaData();// 获取数据结构
			// 获得结果集列数
			int columnCount = rsmd.getColumnCount();// 获取列数
			// 构造泛型结果集
			Map<String, Object> map = new HashMap<String, Object>();

			// 循环结果集
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String k = rsmd.getColumnLabel(i);// 规则查询出来的字段都是小写
					Object v = rs.getObject(k);
					map.put(k, v);
				}

			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			//关闭方法 按照顺序关闭链接对象 语句对象 结果集对象
			close(conn, ps, rs);
		}

	}

	public static Map<String, Object> query(String sql, Object arg) {
		return query(sql, new Object[] { arg });
	}

	public static Map<String, Object> query(String sql) {
		return query(sql, null);
	}

	// 释放内存 关闭方法 按照顺序关闭链接对象 语句对象 
	private static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

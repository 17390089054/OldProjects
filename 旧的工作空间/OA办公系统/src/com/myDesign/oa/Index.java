package com.myDesign.oa;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.MyTools.Check;
import com.MyTools.DBTools;
import com.MyTools.GetNum;
import com.MyTools.LoginTools;

@WebServlet("/index")
public class Index extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!Check.Check(request, response))
		{			
			return;
		}
		else
		{
			HttpSession session =request.getSession();
			
			//系统总用户
			String sql="select count(*) from user ";
			String EmployeeTotal=GetNum.Count(sql);
			session.setAttribute("EmployeeTotal",EmployeeTotal);
			
			/**
			 * 用户部分
			 */
			//系统注册用户
			String sql2="select count(*) from user where user_status=2";
			String EmployeeCheck=GetNum.Count(sql2);
			session.setAttribute("EmployeeCheck", EmployeeCheck);
			
			//系统在职用户
			String sql3="select count(*) from user where user_status=1";
			String EmployeeAvalible=GetNum.Count(sql3);
			session.setAttribute("EmployeeAvalible", EmployeeAvalible);
		
			//系统离职用户
			String sql4="select count(*) from user where user_status=0";
			String EmployeeOut=GetNum.Count(sql4);
			session.setAttribute("EmployeeOut", EmployeeOut);
			
			/**
			 * 部门部分
			 */
			//系统部门
			String sql5="select count(*) from department where d_status=1";
			String DepartmentCount=GetNum.Count(sql5);
			session.setAttribute("DepartmentCount", DepartmentCount);
			
			/**
			 * 活动部分
			 */
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sf.format(new Date());
			//活动结束时间大于当前时间视为活动未结素
			String sql6="select count(*) from activity where e_date>='"+date+"'";
			String Activity=GetNum.Count(sql6);
			session.setAttribute("Activity", Activity);
			
			/**
			 * 任务记录
			 */		
			String sql7="select count(*) from mission where m_status=0";
			String Mission=GetNum.Count(sql7);
			session.setAttribute("Mission", Mission);
			
			/**
			 * 日报部分
			 */
			//日报总数
			String sql8="select count(*) from report ";
			String ReportCount=GetNum.Count(sql8);
			session.setAttribute("ReportCount",ReportCount);
			
			//草稿
			String sql9="select count(*) from report where report_status=0";
			String Report=GetNum.Count(sql9);
			session.setAttribute("Report", Report);
			
			//已提交
			String sql10="select count(*) from report where report_status=1";
			String ReportSubmit=GetNum.Count(sql10);
			session.setAttribute("ReportSubmit", ReportSubmit);
			
			//已审批
			String sql11="select count(*) from report where report_status=2";
			String ReportRead=GetNum.Count(sql11);
			session.setAttribute("ReportRead", ReportRead);
			
			/**
			 * 请假模块
			 */
			//请假总数
			String sql12="select count(*) from rest ";
			String RestTotal=GetNum.Count(sql12);
			session.setAttribute("RestTotal",RestTotal);
			
			//请假申请
			String sql13="select count(*) from rest where rest_status=0 ";
			String RestAdd=GetNum.Count(sql13);
			session.setAttribute("RestAdd",RestAdd);
			
			//请假通过
			String sql14="select count(*) from rest where rest_status=1 ";
			String RestPass=GetNum.Count(sql14);
			session.setAttribute("RestPass",RestPass);
			
			//请假驳回
			String sql15="select count(*) from rest where rest_status=2 ";
			String RestFail=GetNum.Count(sql15);
			session.setAttribute("RestFail",RestFail);
			
			/**
			 * 公告表
			 */
			String sql16="select * from notice ";
			List<Map<String,String>>notice=DBTools.executeQuery(sql16);
			if(notice!=null&&notice.size()>0)
			{
				session.setAttribute("notice", notice);
			}
			
			/**
			 * 收件箱提醒
			 */
			String account=session.getAttribute("account").toString();
			String Sql="select user_id from user where account='"+account+"'";
			Map<String,String>map=new HashMap<String,String>();
			String user_id="";
			map=(Map<String, String>) DBTools.executeQuery(Sql).get(0);
			if(map!=null)
			{
				user_id=map.get("user_id");
			}
			
			int RecID=Integer.parseInt(user_id);
						
			String Sql2="select count(*) from message where RecID in(0,"+RecID+") and Status=0";
			String email=GetNum.Count(Sql2);
			session.setAttribute("email", email);
			
			/**
			 * 添加操作记录
			 */
			String user_name=session.getAttribute("user_name").toString();
			String action="访问了系统主页";
			SimpleDateFormat sf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date2=sf2.format(new Date());
			LoginTools.AddLog(account, user_name, action, date2);
		
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
	}

	
	private String GetNum(String sql) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	

}

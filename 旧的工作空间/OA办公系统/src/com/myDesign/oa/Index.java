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
			
			//ϵͳ���û�
			String sql="select count(*) from user ";
			String EmployeeTotal=GetNum.Count(sql);
			session.setAttribute("EmployeeTotal",EmployeeTotal);
			
			/**
			 * �û�����
			 */
			//ϵͳע���û�
			String sql2="select count(*) from user where user_status=2";
			String EmployeeCheck=GetNum.Count(sql2);
			session.setAttribute("EmployeeCheck", EmployeeCheck);
			
			//ϵͳ��ְ�û�
			String sql3="select count(*) from user where user_status=1";
			String EmployeeAvalible=GetNum.Count(sql3);
			session.setAttribute("EmployeeAvalible", EmployeeAvalible);
		
			//ϵͳ��ְ�û�
			String sql4="select count(*) from user where user_status=0";
			String EmployeeOut=GetNum.Count(sql4);
			session.setAttribute("EmployeeOut", EmployeeOut);
			
			/**
			 * ���Ų���
			 */
			//ϵͳ����
			String sql5="select count(*) from department where d_status=1";
			String DepartmentCount=GetNum.Count(sql5);
			session.setAttribute("DepartmentCount", DepartmentCount);
			
			/**
			 * �����
			 */
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sf.format(new Date());
			//�����ʱ����ڵ�ǰʱ����Ϊ�δ����
			String sql6="select count(*) from activity where e_date>='"+date+"'";
			String Activity=GetNum.Count(sql6);
			session.setAttribute("Activity", Activity);
			
			/**
			 * �����¼
			 */		
			String sql7="select count(*) from mission where m_status=0";
			String Mission=GetNum.Count(sql7);
			session.setAttribute("Mission", Mission);
			
			/**
			 * �ձ�����
			 */
			//�ձ�����
			String sql8="select count(*) from report ";
			String ReportCount=GetNum.Count(sql8);
			session.setAttribute("ReportCount",ReportCount);
			
			//�ݸ�
			String sql9="select count(*) from report where report_status=0";
			String Report=GetNum.Count(sql9);
			session.setAttribute("Report", Report);
			
			//���ύ
			String sql10="select count(*) from report where report_status=1";
			String ReportSubmit=GetNum.Count(sql10);
			session.setAttribute("ReportSubmit", ReportSubmit);
			
			//������
			String sql11="select count(*) from report where report_status=2";
			String ReportRead=GetNum.Count(sql11);
			session.setAttribute("ReportRead", ReportRead);
			
			/**
			 * ���ģ��
			 */
			//�������
			String sql12="select count(*) from rest ";
			String RestTotal=GetNum.Count(sql12);
			session.setAttribute("RestTotal",RestTotal);
			
			//�������
			String sql13="select count(*) from rest where rest_status=0 ";
			String RestAdd=GetNum.Count(sql13);
			session.setAttribute("RestAdd",RestAdd);
			
			//���ͨ��
			String sql14="select count(*) from rest where rest_status=1 ";
			String RestPass=GetNum.Count(sql14);
			session.setAttribute("RestPass",RestPass);
			
			//��ٲ���
			String sql15="select count(*) from rest where rest_status=2 ";
			String RestFail=GetNum.Count(sql15);
			session.setAttribute("RestFail",RestFail);
			
			/**
			 * �����
			 */
			String sql16="select * from notice ";
			List<Map<String,String>>notice=DBTools.executeQuery(sql16);
			if(notice!=null&&notice.size()>0)
			{
				session.setAttribute("notice", notice);
			}
			
			/**
			 * �ռ�������
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
			 * ��Ӳ�����¼
			 */
			String user_name=session.getAttribute("user_name").toString();
			String action="������ϵͳ��ҳ";
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

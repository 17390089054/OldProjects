package com.wrf.Mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * @package:        com.wrf.Mail
 * @Description:  TODO(基于JavaMail开发的邮件发送) 
 * @author        knight
 * @Date          2018年2月19日 下午7:47:15 
 */

public class Mail extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//接收前台参数
		String userName = request.getParameter("recipient");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//定义发送者的账号密码
		String sender="q18079639436@163.com";
		String password="wazx20160302";
		
		try {
		//读取邮箱协议
		Properties pro=new Properties();
		//stmp协议  需要账号密码验证
		pro.put("mail.transport.protocol", "smtp");//定义邮箱协议
		pro.put("mail.host", "smtp.163.com");//定义邮箱发送主机
		pro.put("mail.smtp.auth", true);//是否需要密码
		
		//创建邮箱
		Session session=Session.getInstance(pro);
		session.setDebug(true);
		MimeMessage mm=new MimeMessage(session);
		//定义邮件发送源	
		Address ad=new InternetAddress(sender);
		mm.setFrom(ad);
		//定义邮件接收者
		mm.setRecipients(Message.RecipientType.TO, userName);
		mm.setSubject(title);//标题
		mm.setSentDate(new Date());//发送时间
		mm.setText(content);//内容
		mm.saveChanges();//保存内容
		
		//定义邮件发送工具
		Transport ts=session.getTransport();
		ts.connect(sender, password);
		ts.sendMessage(mm, mm.getAllRecipients());
		ts.close();//关闭工具
		
		//返回至前台
		request.setAttribute("msg", "发送成功");
		request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("message.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
		
		
	}
}

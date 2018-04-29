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
 * @Description:  TODO(����JavaMail�������ʼ�����) 
 * @author        knight
 * @Date          2018��2��19�� ����7:47:15 
 */

public class Mail extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�����ַ�����
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//����ǰ̨����
		String userName = request.getParameter("recipient");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//���巢���ߵ��˺�����
		String sender="q18079639436@163.com";
		String password="wazx20160302";
		
		try {
		//��ȡ����Э��
		Properties pro=new Properties();
		//stmpЭ��  ��Ҫ�˺�������֤
		pro.put("mail.transport.protocol", "smtp");//��������Э��
		pro.put("mail.host", "smtp.163.com");//�������䷢������
		pro.put("mail.smtp.auth", true);//�Ƿ���Ҫ����
		
		//��������
		Session session=Session.getInstance(pro);
		session.setDebug(true);
		MimeMessage mm=new MimeMessage(session);
		//�����ʼ�����Դ	
		Address ad=new InternetAddress(sender);
		mm.setFrom(ad);
		//�����ʼ�������
		mm.setRecipients(Message.RecipientType.TO, userName);
		mm.setSubject(title);//����
		mm.setSentDate(new Date());//����ʱ��
		mm.setText(content);//����
		mm.saveChanges();//��������
		
		//�����ʼ����͹���
		Transport ts=session.getTransport();
		ts.connect(sender, password);
		ts.sendMessage(mm, mm.getAllRecipients());
		ts.close();//�رչ���
		
		//������ǰ̨
		request.setAttribute("msg", "���ͳɹ�");
		request.getRequestDispatcher("message.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("message.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		
		
		
	}
}

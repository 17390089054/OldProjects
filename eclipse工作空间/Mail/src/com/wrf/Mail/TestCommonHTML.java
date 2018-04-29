package com.wrf.Mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @ClassName:     TestCommonHTML.java
 * @Description:   ��org.apache.commons.mail����HTML�ʼ� 
 * @author          knight
 * @version         V1.0  
 * @Date           2018��2��20�� ����12:40:04
 */
public class TestCommonHTML {  
    public TestCommonHTML() {  
    }  
  
    public static void main(String[] args) {  
        // ��Ҫʹ��SimpleEmail,�������������  
        HtmlEmail email = new HtmlEmail();  
        // SimpleEmail email = new SimpleEmail();  
        try {  
            // ������SMTP���ͷ����������֣�qq�����£�  
            email.setHostName("smtp.163.com");  
            // �ַ����뼯������  
            email.setCharset("gbk");  
            // �ռ��˵�����  
            email.addTo("2659586580@qq.com");  
            // �����˵�����  
            email.setFrom("q18079639436@163.com");  
            // �����Ҫ��֤��Ϣ�Ļ���������֤���û���-���롣�ֱ�Ϊ���������ʼ��������ϵ�ע�����ƺ�����  
            email.setAuthentication("q18079639436@163.com", "wazx20160302");  
            email.setSubject("����3��00���������ۣ���׼ʱ�μ�");  
            // Ҫ���͵���Ϣ������ʹ����HtmlEmail���������ʼ�������ʹ��HTML��ǩ  
            email.setMsg("<h1 style='color:red'>����3��00����������</h1>" + " ��׼ʱ�μӣ�");  
            // ����  
            email.send();  
  
            System.out.println("�ʼ����ͳɹ�!");  
        } catch (EmailException e) {  
            e.printStackTrace();  
            System.out.println("�ʼ�����ʧ��!");  
        }  
  
    }  
}  

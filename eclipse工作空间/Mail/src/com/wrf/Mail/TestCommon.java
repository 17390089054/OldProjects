package com.wrf.Mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
/**
 * @ClassName:     TestCommon.java
 * @Description:   ��org.apache.commons.mail������ͨ�ʼ� 
 * @author          knight
 * @version         V1.0  
 * @Date           2018��2��20�� ����12:40:18
 */
public class TestCommon {  
    public TestCommon() {  
    }  
  
    public static void main(String[] args) {  
        SimpleEmail email = new SimpleEmail();  
        email.setHostName("smtp.163.com");// ����ʹ�÷������ʼ����ʼ���������������qq����Ϊ�����������磺��smtp.163.com������smtp.sohu.com����  
        try {  
            // �ռ�������  
            email.addTo("2823863294@qq.com");  
            // ��������������֤  
            email.setAuthentication("q18079639436@163.com", "wazx20160302");  
            // ����������  
            email.setFrom("q18079639436@163.com");  
            // �ʼ�����  
            email.setSubject("zhipeng-JavaMail");  
            // �ʼ�����  
            email.setMsg("Kobe Bryante Never Stop Trying");  
            // �����ʼ�  
            email.send();  
            System.out.println("�ʼ����ͳɹ�!");
        } catch (EmailException ex) {  
            ex.printStackTrace();  
        }  
    }  
}  
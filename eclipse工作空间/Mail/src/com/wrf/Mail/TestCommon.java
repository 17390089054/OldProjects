package com.wrf.Mail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
/**
 * @ClassName:     TestCommon.java
 * @Description:   用org.apache.commons.mail发送普通邮件 
 * @author          knight
 * @version         V1.0  
 * @Date           2018年2月20日 上午12:40:18
 */
public class TestCommon {  
    public TestCommon() {  
    }  
  
    public static void main(String[] args) {  
        SimpleEmail email = new SimpleEmail();  
        email.setHostName("smtp.163.com");// 设置使用发电子邮件的邮件服务器，这里以qq邮箱为例（其它例如：【smtp.163.com】，【smtp.sohu.com】）  
        try {  
            // 收件人邮箱  
            email.addTo("2823863294@qq.com");  
            // 邮箱服务器身份验证  
            email.setAuthentication("q18079639436@163.com", "wazx20160302");  
            // 发件人邮箱  
            email.setFrom("q18079639436@163.com");  
            // 邮件主题  
            email.setSubject("zhipeng-JavaMail");  
            // 邮件内容  
            email.setMsg("Kobe Bryante Never Stop Trying");  
            // 发送邮件  
            email.send();  
            System.out.println("邮件发送成功!");
        } catch (EmailException ex) {  
            ex.printStackTrace();  
        }  
    }  
}  
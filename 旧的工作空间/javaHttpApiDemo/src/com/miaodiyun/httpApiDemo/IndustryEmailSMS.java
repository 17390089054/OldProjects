package com.miaodiyun.httpApiDemo;

import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 短信邮验证码通知短信接口
 * 
 * @ClassName: IndustryEmailSMS
 * @Description: 短信邮验证码通知短信接口
 *
 */
public class IndustryEmailSMS
{
	private static String operation = "/industryEmailSMS/sendEmailSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "1361305****";
	private static String smsContent = "【秒嘀科技】您在秒嘀注册的验证码为54789。";

	/**
	 * 短信邮验证码通知短信
	 */
	public static void execute()
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
}

package com.miaodiyun.httpApiDemo;

import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 短信邮会员营销短信接口
 * 
 * @ClassName: AffMarkEmailSMS
 * @Description: 短信邮会员营销短信接口
 *
 */
public class AffMarkEmailSMS
{
	private static String operation = "/affMarkEmailSMS/sendEmailSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "1361305****";
	private static String smsContent = "【秒嘀科技】您的优惠券就快过期啦！不想白白浪费，就快来使用吧！戳： m.miaodiyun.com 使用！回TD退订 。";

	/**
	 * 短信邮会员营销短信
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

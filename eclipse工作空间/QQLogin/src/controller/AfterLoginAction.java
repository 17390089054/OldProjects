package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.Avatar;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

/** 
 * @package:        controller
 * @Description:  TODO(登陆后跳转类) 
 * @author        knight
 * @Date          2018年2月7日 下午2:47:26 
 */
@WebServlet("/afterlogin")
public class AfterLoginAction extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应类型和字符编码
		response.setContentType("text/html;charset=utf-8");
		try {
			//获取Access_Token的对象
			Oauth oauth=new Oauth();	
			AccessToken accessTokenObj = oauth.getAccessTokenByRequest(request);
			//获取accessToken值
			String accessToken = accessTokenObj.getAccessToken();
			//获取用户对象
			OpenID openIdObj=new OpenID(accessToken);
			//获取用户唯一标识
			String userOpenID = openIdObj.getUserOpenID();
			
			//获取用户对象
			UserInfo userInfoObj=new UserInfo(accessToken,userOpenID);
			UserInfoBean userInfo = userInfoObj.getUserInfo();
			//获取用户性别
			String gender = userInfo.getGender();
			//获取用户昵称
			String nickname = userInfo.getNickname();
			//获取用户头像
			Avatar avatar = userInfo.getAvatar();
			String avatarURL100 = avatar.getAvatarURL100();
			//获取用户等级
			int level = userInfo.getLevel();
			//获取用户黄钻信息
			int ret = userInfo.getRet();
			//获取用户描述信息
			String msg = userInfo.getMsg();
			
			System.out.println("昵称:"+nickname);
			System.out.println("性别:"+gender);
			System.out.println("头像:"+avatarURL100);
			System.out.println("等级:"+level);
			System.out.println("黄钻:"+ret);
			System.out.println("信息:"+msg);
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
			
			
			
	}
}

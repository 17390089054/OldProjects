package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;

/** 
 * @package:        com.wrf.qqLogin.Controler
 * @Description:  TODO(登陆后获取用户请求类) 
 * @author        knight
 * @Date          2018年2月7日 上午10:59:41 
 */
@WebServlet("/qqLogin")
public class QQLoginSelectAction extends HttpServlet {
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				response.sendRedirect(new Oauth().getAuthorizeURL(request));
			} catch (QQConnectException e) {
				
				e.printStackTrace();
			}
		
		}
}

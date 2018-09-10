package magicyangyz.news.user.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.news.user.domain.User;
import magicyangyz.news.user.service.UserException;
import magicyangyz.news.user.service.UserService;
import magicyangyz.servlet.BaseServlet;
import magicyangyz.utils.CommonUtils;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	public String adminLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		try {
			User loginUser = userService.adminLogin(form);
			req.getSession().setAttribute("session_user", loginUser);
			return "r:/my_news/adminjsps/admin/index.jsp";
		} catch (UserException e) {
			if(e.getMessage().equals("您不是管理员！3秒后您将跳转到普通用户登录界面！")){
				resp.setHeader("refresh", "3;url=/user/free/login.jsp");
			}
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("form", form);
			return "/adminjsps/login.jsp";
		}
	}
	public String regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
		UserService userService = new UserService();
		int count = userService.getCount();
		User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		form.setUserId(count + 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		form.setRegisterDate(date);
		form.setEnable("use");
		try {
			userService.regist(form);
			req.setAttribute("msg", "恭喜您，注册成功！");
			return "/jsps/msg.jsp";
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("form", form);
			return "/user/free/register.jsp";
		}
	}
	public String login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService userService = new UserService();
		
			User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		try {
			User loginUser = userService.login(form);
			req.getSession().setAttribute("session_user", loginUser);
			return "r:/my_news/index.jsp";
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("form", form);
			return "/user/free/login.jsp";
		}
	}
	
	public String changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UserException {
		if(req.getSession().getAttribute("session_user")==null){
			req.setAttribute("msg","您还没有登录，请先登录！");
			return "/jsps/msg.jsp";
		}
		UserService userService = new UserService();
		User form = CommonUtils.toBean(req.getParameterMap(), User.class);
		User user = (User) req.getSession().getAttribute("session_user");
		String userName = user.getName();
		form.setName(userName);
		form.setPassword(req.getParameter("oldPassword"));
		String newPassword = req.getParameter("newPassword");
		try{
			userService.changePassword(form,newPassword);
			req.setAttribute("msg","恭喜您，修改密码成功！请重新登录！");
			return "/jsps/msg.jsp";
		} catch (UserException e) {
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("newPassword", newPassword);
			req.setAttribute("form", form);
			return "/user/manage/changePassword.jsp";
		}
	}
	
	public String quit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, UserException {
		req.getSession().invalidate();
		return "r:/my_news/index.jsp";
	}

}

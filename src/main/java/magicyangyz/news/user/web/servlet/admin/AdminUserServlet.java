package magicyangyz.news.user.web.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.news.newsType.domain.NewsType;
import magicyangyz.news.user.domain.User;
import magicyangyz.news.user.service.UserException;
import magicyangyz.news.user.service.UserService;
import magicyangyz.servlet.BaseServlet;
import magicyangyz.utils.CommonUtils;

public class AdminUserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	public String findAllUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		List<User> userList = userService.findAllUser();
		req.setAttribute("userList", userList);
		if(req.getParameter("type")!=null)
			req.setAttribute("type", req.getParameter("type"));
		else
			req.setAttribute("type", req.getAttribute("type"));
		return "/adminjsps/admin/user/list.jsp";
	}
	
	public String changeEnable(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String userId = req.getParameter("userId");
		userService.changeEnable(userId);
		req.setAttribute("type", "changeEnable");
		return findAllUser(req,res);
	}
	
	public String changeAdminPre(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String userId = req.getParameter("userId");
		User user = userService.findByUserId(userId);
		req.setAttribute("user", user);
		req.setAttribute("type", "changeAdmin");
		return "/adminjsps/admin/user/mod.jsp";
	}
	
	public String changeAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String userId = req.getParameter("userId");
		String NewAdmin = req.getParameter("UserType");
		userService.changeAdmin(userId,NewAdmin);
		return "/admin/AdminUserServlet?method=findAllUser&type=changeAdmin";
	}	
	
	public String delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String userId = req.getParameter("userId");
		userService.delete(userId);
		req.setAttribute("type", "delete");
		return findAllUser(req,res);
	}
}

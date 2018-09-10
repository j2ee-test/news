package magicyangyz.news.newsType.web.servlet.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.news.newsType.domain.NewsType;
import magicyangyz.news.newsType.service.NewsTypeService;
import magicyangyz.servlet.BaseServlet;
import magicyangyz.utils.CommonUtils;

public class AdminNewsTypeServlet extends BaseServlet {
	private NewsTypeService newsTypeService = new NewsTypeService();
	
	public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		req.setAttribute("newsTypeList", newsTypeService.findAll());
		return "/adminjsps/admin/newsType/list.jsp";
	}
	
	public String add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		NewsType newsType = CommonUtils.toBean(req.getParameterMap(), NewsType.class);
		newsType.setTid(newsTypeService.countTypes()+1);
		newsTypeService.add(newsType);
		return findAll(req,res);
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String tids = req.getParameter("tid");
		int tid = Integer.parseInt(tids);
		try {
			newsTypeService.delete(tid);
			return findAll(req,res);
		} catch (NewsTypeException e) {
			req.setAttribute("msg", e.getMessage());
			return "/adminjsps/msg.jsp";
		}
	}
	
	public String editPre(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		String tid = req.getParameter("tid");
		req.setAttribute("newsType", newsTypeService.load(tid));
		return "/adminjsps/admin/newsType/mod.jsp";
	}
	
	public String edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException{
		NewsType newsType = CommonUtils.toBean(req.getParameterMap(), NewsType.class);
		newsTypeService.edit(newsType);
		return findAll(req,res);
	}
}

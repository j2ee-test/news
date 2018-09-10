package magicyangyz.news.newsType.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.news.newsType.service.NewsTypeService;
import magicyangyz.servlet.BaseServlet;

public class NewsTypeServlet extends BaseServlet {
	private NewsTypeService newsTypeService= new NewsTypeService();
	
	public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		req.setAttribute("newsTypeList", newsTypeService.findAll());
		return "/jsps/left.jsp";
	}
}

package magicyangyz.news.news.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.bean.PageBean;
import magicyangyz.news.news.domain.News;
import magicyangyz.news.news.service.NewsService;
import magicyangyz.servlet.BaseServlet;

public class NewsServlet extends BaseServlet {
	private NewsService newsService = new NewsService();

//	public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		req.setAttribute("newsList", newsService.findAll());
//		return "/jsps/news/list.jsp";
//	}
	
	private int getPc(HttpServletRequest req){
		String value = req.getParameter("pc");
		if(value == null || value.trim().isEmpty()){
			return 1;
		}
		return Integer.parseInt(value);
	}
	//分页findAll()
	public String findAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pc = getPc(req);
		int ps = 1;//每页多少行记录
		PageBean<News> pb = newsService.findAll(pc,ps);
		req.setAttribute("pb", pb);
		req.setAttribute("searchMethod", "findAll");
		return "/jsps/news/list.jsp";
	}
	
	public String findByNewsType(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pc = getPc(req);
		int ps = 1;//每页多少行记录
		String tids = req.getParameter("tid");
		if(tids.isEmpty()){
			tids = (String) req.getAttribute("tid");
		}else{
			req.setAttribute("tids",tids );
		}
		int tid = Integer.parseInt(tids);
		PageBean<News> pb = newsService.findByNewsType(pc,ps,tid);
		req.setAttribute("pb", pb);
		req.setAttribute("searchMethod", "findByNewsType");

		return "/jsps/news/list.jsp";
	}
}

package magicyangyz.news.news.web.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magicyangyz.news.news.domain.News;
import magicyangyz.news.news.service.NewsService;
import magicyangyz.servlet.BaseServlet;
import magicyangyz.utils.CommonUtils;

public class AdminNewsServlet extends BaseServlet {
	private NewsService newsService = new NewsService();

	public String addPre(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("newsTypeList", newsService.findAllinAll());
		return "/adminjsps/admin/news/add.jsp";
	}
	
	public String add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		News form = CommonUtils.toBean(req.getParameterMap(), News.class);
		int count = newsService.getCount();
		form.setNewsId(count + 1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		form.setPublishTime(date);
		form.setExam(0);
		form.setAuthor(req.getParameter("author"));
		newsService.add(form);
		return "/adminjsps/admin/news/add.jsp";
	}
	
	public String check(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String newsId = req.getParameter("newsId");
		newsService.checkNews(newsId);
		return checkPre(req,res);
	}
	
	public String checkPre(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<News> newsList = newsService.checkNewsPre();  
		req.setAttribute("type", "check");
		req.setAttribute("newsList", newsList);
		return "/adminjsps/admin/news/list.jsp";
	}
	
	public String deletePre(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<News> newsList = newsService.deleteNewsPre(); 
		req.setAttribute("type", "delete");
		req.setAttribute("newsList", newsList);
		return "/adminjsps/admin/news/list.jsp";
	}
	
	public String delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String newsId = req.getParameter("newsId");
		newsService.deleteNews(newsId);
		return deletePre(req,res);
	}
}

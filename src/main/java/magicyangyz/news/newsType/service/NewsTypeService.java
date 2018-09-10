package magicyangyz.news.newsType.service;

import java.sql.SQLException;
import java.util.List;

import magicyangyz.news.news.dao.NewsDao;
import magicyangyz.news.newsType.dao.NewsTypeDao;
import magicyangyz.news.newsType.domain.NewsType;
import magicyangyz.news.newsType.web.servlet.admin.NewsTypeException;

public class NewsTypeService {
	private NewsTypeDao newsTypeDao = new NewsTypeDao();
	private NewsDao newsDao = new NewsDao();

	public List<NewsType> findAll() throws SQLException {
		return newsTypeDao.findAll();
	}
	
	public int countTypes() throws SQLException{
		return newsTypeDao.countTypes();
	}

	public void add(NewsType newsType) throws SQLException {
		newsTypeDao.add(newsType);
	}

	public void delete(int tid) throws NewsTypeException{
		if(!newsTypeDao.searchNewsType(tid)) throw new NewsTypeException("该分类不存在！");
		newsDao.deleteTheTypeOfNews(tid);
		newsTypeDao.deleteNewsType(tid);
	}

	public NewsType load(String tid) {
		return newsTypeDao.load(tid);
	}

	public void edit(NewsType newsType) {
		newsTypeDao.mod(newsType);
	}
	
}

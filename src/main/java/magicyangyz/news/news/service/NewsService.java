package magicyangyz.news.news.service;

import java.util.List;

import magicyangyz.bean.PageBean;
import magicyangyz.news.news.dao.NewsDao;
import magicyangyz.news.news.domain.News;
import magicyangyz.news.newsType.dao.NewsTypeDao;
import magicyangyz.news.newsType.domain.NewsType;

public class NewsService {
	private NewsDao newsDao = new NewsDao();
	private NewsTypeDao newsTypeDao = new NewsTypeDao();
	public PageBean findAll(int pc, int ps){
		return newsDao.findAll(pc,ps);
	}
	
	public PageBean findByNewsType(int pc, int ps,int tid){
		return newsDao.findByNewsType(pc,ps,tid);
	}

	public List<NewsType> findAllinAll() {
		return newsTypeDao.findAll();
	}

	public int getCount() {
		return newsDao.count();
	}

	public void add(News form) {
		newsDao.add(form);
	}

	public void checkNews(String newsId) {
		newsDao.check(newsId);
	}

	public List<News> checkNewsPre() {
		return newsDao.checkPre();
	}

	public List<News> deleteNewsPre() {
		return newsDao.deletePre();
	}

	public void deleteNews(String newsId) {
		newsDao.delete(newsId);
	}
}

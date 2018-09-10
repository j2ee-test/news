package magicyangyz.news.news.dao;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.inject.spi.Bean;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import magicyangyz.bean.PageBean;
import magicyangyz.news.news.domain.News;
import magicyangyz.news.newsType.domain.NewsType;
import magicyangyz.news.tools.JdbcUtils;
import magicyangyz.news.user.domain.User;

public class NewsDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	
	public List<News> findAllinAll(){
		String sql = "SELECT * FROM news";
		try{
			return qr.query(sql, new BeanListHandler<News>(News.class));
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public PageBean<News> findAll(int pc, int ps){
		try {
			PageBean<News> pb = new PageBean<News>();
			pb.setPc(pc);
			pb.setPs(ps);
			String sql = "SELECT count(*) FROM news WHERE exam = 1";
			Number num = (Number) qr.query(sql, new ScalarHandler());
			int tr = num.intValue();
			pb.setTr(tr);
			
			sql = "SELECT * FROM news WHERE exam = 1 ORDER BY newsId limit ?,? ";
			
			List<News> beanList = qr.query(sql, new BeanListHandler<News>(News.class),(pc-1)*ps,ps);
			pb.setBeanList(beanList);
			return pb;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public PageBean<News> findByNewsType(int pc, int ps, int tid){
		try {
			PageBean<News> pb = new PageBean<News>();
			pb.setPc(pc);
			pb.setPs(ps);
			String sql = "SELECT count(*) FROM news a,newstype b WHERE a.newsType = b.tname and b.tid=? and a.exam = 1";
			Number num = (Number) qr.query(sql, new ScalarHandler(),tid);
			int tr = num.intValue();
			pb.setTr(tr);
			
			sql = "SELECT * FROM news a,newstype b WHERE a.newsType = b.tname and b.tid=? and a.exam = 1 ORDER BY newsId limit ?,?";
			
			List<News> beanList = qr.query(sql, new BeanListHandler<News>(News.class),tid,(pc-1)*ps,ps);
			pb.setBeanList(beanList);
			return pb;
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	private String gerUrl(HttpServletRequest req){
		String contextPath = req.getContextPath();
		String servletPath = req.getServletPath();
		String queryString = req.getQueryString();
		
		return contextPath + servletPath + "?" + queryString;
	}
	
	public void deleteTheTypeOfNews(int tid){
		String sql = "SELECT * FROM newstype WHERE tid=?";
		String tname = "";
		try{
			NewsType nt = qr.query(sql, new BeanHandler<NewsType>(NewsType.class),tid);
			tname = nt.getTname();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		sql = "DELETE FROM news WHERE newsType = ?";
		try{
			qr.update(sql,tname);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}	
	}

	public int count(){  
		String sql = "SELECT * FROM news order by newsId";
		try{
			List<News> list = (List) qr.query(sql, new BeanListHandler<News>(News.class));
			int id = list.get(list.size()-1).getNewsId();
			return id;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void add(News form) {
		String sql = "insert into news values(?,?,?,?,?,?,?,?)";
		try{
			qr.update(sql, form.getNewsId(), form.getNewsType(),form.getAuthor(),form.getCaption(),form.getContent(),form.getNewsTime(),form.getPublishTime(),form.getExam());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<News> checkPre(){
		String sql = "SELECT * FROM news WHERE exam = 0";
		try{
			return qr.query(sql, new BeanListHandler<News>(News.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void check(String newsId) {
		String sql = "UPDATE news SET exam = 1 WHERE newsId = ?";
		try{
			qr.update(sql,newsId);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public List<News> deletePre() {
		String sql = "SELECT * FROM news";
		try{
			return qr.query(sql, new BeanListHandler<News>(News.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void delete(String newsId) {
		String sql = "DELETE FROM news WHERE newsId = ?";
		try{
			qr.update(sql,newsId);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}

package magicyangyz.news.newsType.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import magicyangyz.news.newsType.domain.NewsType;
import magicyangyz.news.tools.JdbcUtils;

public class NewsTypeDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

	public List<NewsType> findAll(){
		String sql="SELECT * FROM newstype";
		try{
			return qr.query(sql, new BeanListHandler<NewsType>(NewsType.class));
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public int countTypes() throws SQLException{
		String sql = "SELECT * FROM newstype order by tid";	
		List<NewsType> list = (List) qr.query(sql, new BeanListHandler<NewsType>(NewsType.class));
		int tid = list.get(list.size()-1).getTid();	
		return tid;
	}

	public void add(NewsType newsType) throws SQLException {
		String sql = "INSERT into newstype values(?,?)";
		qr.update(sql,newsType.getTid(),newsType.getTname());
	}

	public void deleteNewsType(int tid){
		String sql = "DELETE FROM newstype WHERE tid = ?";
		try{
			qr.update(sql,tid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public boolean searchNewsType(int tid){
		String sql = "SELECT * FROM newstype WHERE tid = ?";
		try{
			if(qr.query(sql, new BeanHandler<NewsType>(NewsType.class),tid) == null)
				return false;
			return true;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public NewsType load(String tid) {
		String sql = "SELECT * FROM newstype WHERE tid = ?";
		try{
			return qr.query(sql, new BeanHandler<NewsType>(NewsType.class),tid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void mod(NewsType newstype) {
		String sql = "UPDATE newstype SET tname = ? WHERE tid = ?";
		try{
			qr.update(sql,newstype.getTname(),newstype.getTid());
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
//	pulic void delByNewsType
	
}

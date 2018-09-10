package magicyangyz.news.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import magicyangyz.news.tools.JdbcUtils;
import magicyangyz.news.user.domain.User;

public class UserDao {
	private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
	//得到数据库中最后一个元素的userId
	public int count() throws SQLException{
//		String sql = "SELECT COUNT(*) FROM user";
//		return ((Long)qr.query(sql,new ScalarHandler())).intValue() ;
		String sql = "SELECT * FROM user order by userId";
		
		List<User> list = (List) qr.query(sql, new BeanListHandler<User>(User.class));
		int id = list.get(list.size()-1).getUserId();
		
		return id;
	}
	
	//添加新用户
	public void add(User user) throws SQLException {
		String sql = "insert into user values(?,?,?,?,?,?)";
		qr.update(sql, user.getUserId(), user.getType(),user.getName(), user.getPassword(),user.getRegisterDate(),user.getEnable());
	}
	
	//修改密码
	public void changePassword(User user, String newPassword) throws SQLException{
		String sql = "UPDATE user SET password = ? WHERE name = ? ";
		qr.update(sql,newPassword,user.getName());
	}
	
	//修改用户type
	public void changeType(User user,String newType) throws SQLException{
		String sql = "UPDATE user SET type = ? WHERE name = ? ";
		qr.update(sql,newType,user.getName());
	}
	
	//根据userId查询用户enable
	public String searchEnableByUserId(String userId){
		String sql = "SELECT * FROM user WHERE userId = ? ";
		try{
			User use = qr.query(sql, new BeanHandler<User>(User.class),userId);
			return use.getEnable();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//修改用户enable
	public void changeEnable(String userId){
		String sql = "UPDATE user SET enable = ? WHERE userId = ? ";
		try{
			if(searchEnableByUserId(userId).equals("stop"))
				qr.update(sql,"use",userId);
			else
				qr.update(sql,"stop",userId);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//删除用户
	public void delUser(String userId){
		String sql = "DELETE from user WHERE userId = ?";
		try{
			qr.update(sql,userId);
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	//根据用户名查询记录
	public User findByUserName(String userName) throws SQLException{
		String sql = "SELECT * FROM user WHERE name=?";
		return qr.query(sql,new BeanHandler<User>(User.class),userName);
	}

	public List<User> findAllUser() {
		String sql="SELECT * FROM user";
		try{
			return qr.query(sql, new BeanListHandler<User>(User.class));
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public User findByUserId(String userId) {
		String sql="SELECT * FROM user WHERE userId = ?";
		try{
			return qr.query(sql, new BeanHandler<User>(User.class),userId);
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void changAdmin(String userId, String newAdmin) {
		String sql="UPDATE user SET type = ? WHERE userId = ?";
		try{
			qr.update(sql, newAdmin, userId );
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}

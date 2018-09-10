package magicyangyz.news.user.service;

import java.sql.SQLException;
import java.util.List;

import magicyangyz.news.user.dao.UserDao;
import magicyangyz.news.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public void regist(User form) throws UserException, SQLException {
			//检验用户名
			User user = userDao.findByUserName(form.getName());
			if(user!=null) throw new UserException("用户名已被注册!");
			
			userDao.add(form);
	}
	 
	public int getCount(){
		try {
			return userDao.count();	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public User login(User form) throws UserException{
		try {
			User user = userDao.findByUserName(form.getName());
			if(user==null) throw new UserException("用户名不存在！");
			if(!user.getPassword().equals(form.getPassword()))
				throw new UserException("密码错误！");
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public void changePassword(User form,String newPassword) throws UserException{
		try {
			User user = userDao.findByUserName(form.getName());
			if(!user.getPassword().equals(form.getPassword()))
				throw new UserException("旧密码输入有误！");
			userDao.changePassword(user, newPassword);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
//	
//	public User login(String username, String password) {
//		try {
//			return userDao.login(username, password);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}

	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	public void changeEnable(String userId) {
		userDao.changeEnable(userId);
	}
	
	public User findByUserId(String userId){
		return userDao.findByUserId(userId);
	}

	public void changeAdmin(String userId, String newAdmin) {
		userDao.changAdmin(userId,newAdmin);
	}

	public void delete(String userId) {
		userDao.delUser(userId);
	}

	public User adminLogin(User form) throws UserException{
		try {
			User user = userDao.findByUserName(form.getName());
			if(user==null) throw new UserException("该管理员不存在！");
			if(!user.getPassword().equals(form.getPassword()))
				throw new UserException("密码错误！");
			if(!user.getType().equals("manager"))
				throw new UserException("您不是管理员！");
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

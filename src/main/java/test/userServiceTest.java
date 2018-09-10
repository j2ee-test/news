package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import magicyangyz.news.tools.JdbcUtils;
import magicyangyz.news.user.dao.UserDao;
import magicyangyz.news.user.domain.User;
import magicyangyz.news.user.service.UserService;

public class userServiceTest {
	@Test
	public void testRegist() throws Exception{
		User user = new User(4,"test","user","123123","2018-06-09 08:38:17","use");
		UserService userservice = new UserService();
		userservice.regist(user);
	}
	
	
	///dao
	@Test
	public void testAdd() throws Exception{
		UserDao userdao = new UserDao();
		JdbcUtils a = new JdbcUtils();
		User user = new User(5,"test","user","123123","2018-06-09 08:38:17","use");
		userdao.add(user);
	}
	@Test
	public void testChangePassword() throws Exception{
		UserDao userdao = new UserDao();
		User user = new User(4,"test","user","123123","2018-06-09 08:38:17","use");
		userdao.changePassword(user,"321321");
	}
	@Test
	public void testChangeEnable() throws Exception{
		UserDao userdao = new UserDao();
		String userId = new String("4");
		userdao.changeEnable(userId);
	}	
	@Test
	public void testChangeType() throws Exception{
		UserDao userdao = new UserDao();
		User user = new User(4,"test","user","123123","2018-06-09 08:38:17","use");
		userdao.changeType(user,"manager");
	}	
	@Test
	public void testSearchEnableByUserId() throws Exception{
		UserDao userdao = new UserDao();
		String userId = new String("4");
		String enable = userdao.searchEnableByUserId(userId);
		assertEquals("use", enable);
	}
	@Test
	public void testDelUser() throws Exception{
		UserDao userdao = new UserDao();
		String userId = new String("4");
		userdao.delUser(userId);
	}
	@Test
	public void testFindByUserId() throws Exception{
		UserDao userdao = new UserDao();
		String userId = new String("4");
		userdao.findByUserId(userId);
	}
	@Test
	public void testFindAllUser() throws Exception{
		UserDao userdao = new UserDao();
		List<User> userList = userdao.findAllUser();
		assertEquals(userList.size(),3);	
	}
}

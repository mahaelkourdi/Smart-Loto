package business;

import java.util.List;

import models.User;
import services.UserDao;

public class ServicesDefault implements Services{
	
	private UserDao userDao;

	public ServicesDefault(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	/*public User selectUser(int id) {
		return this.userDao.select(id);
	}*/
	
	public User selectUser(String username, String password) {
		
		return this.userDao.select(username, password);
	}

	public List<User> selectUsers() {
		return this.userDao.selectAll();
	}
	
	public int insertUser(User user) {
		
		return this.userDao.insert(user);
	}

	
	public void deleteUser(User user) {
		
		this.userDao.delete(user);
	}

	
	public void updateUser(User user) {
		
		this.userDao.update(user);
	}


}

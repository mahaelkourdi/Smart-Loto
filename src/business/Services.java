package business;

import java.util.List;

import models.User;

public interface Services {
	//public User selectUser(int id);
	public User selectUser(String username, String password); 
	public List<User> selectUsers();
	public int insertUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	
}

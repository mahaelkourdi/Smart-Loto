package services;

import java.util.List;

import models.User;

public interface UserDao {
	
	public User select(String username);
	public User select(String username, String password); 
	public List<User> selectAll();
	public int insert(User user);
	public void delete(User user);
	public void update(User user);
}

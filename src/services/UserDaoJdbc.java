package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jdbc.Database;
import jdbc.RowMapper;
import models.User;

public class UserDaoJdbc implements UserDao {
	private Database db;
	
	public UserDaoJdbc(Database db) {
		this.db = db;
	}
	
	public User select(int id) {
		String data[][] = db.select("person", "id", id);
		User u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUser(data[i]);
		}
		return u;
	}

	public User select(String username) {
		String data[][] = db.select("user", "username", username);
		User u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUser(data[i]);
		}
		return u;
	}

	
	public User select(String username, String password) {

		String data[][] = db.selectLike("user", "username", username);
		User u = null;
		
		for (int i = 1; i < data.length; i++) {
			u = RowMapper.getUser(data[i]);
			if(u.getPassword().equals(password)) {
				
				return u;
			}
		}
		return null;
	}
	
	
	public int insert(User user) {
		User u = select(user.getUsername());
		if(u == null) {
			HashMap<String, Object> keyValue = new HashMap<>();
			keyValue.put("username", user.getUsername());
			keyValue.put("password", user.getPassword());
			keyValue.put("email", user.getEmail());
			if(db.insert("user", keyValue) == true) {
				return 1;
			}
			return -1;
		}
		return 0;
	}

	
	public void delete(User user) {
		db.delete("user", "iduser", "" + user.getId());
	}
 
	public void update(User user) {
		db.update("user", user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
	}

	@Override
	public List<User> selectAll() {
		String data[][] = db.select("user");
		List<User> users = new ArrayList<>();
		for (int i = 1; i < data.length; i++) {
			users.add(RowMapper.getUser(data[i]));
		}
		return users;
	}
}

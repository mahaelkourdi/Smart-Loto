package jdbc;

import business.Services;
import business.ServicesDefault;
import models.User;
import services.UserDaoJdbc;
import services.UserDao;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		DataSource ds = new MySqlDataSource();
		Database db = new Database(ds);
		System.out.println(ds.getConnection());
		UserDao u1 = new UserDaoJdbc(db);
	}

}

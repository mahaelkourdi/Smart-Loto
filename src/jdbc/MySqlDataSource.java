package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDataSource extends DataSource {

	private static final  String MySQL_DRIVER= "com.mysql.jdbc.Driver";
	private static final String MYSQL_BRIDGE="jdbc:mysql:";
	
	public MySqlDataSource() {
		super(MySQL_DRIVER,MYSQL_BRIDGE+ "//"+"localhost:8889/"+"jeuloto","root","root");
	}

	public MySqlDataSource(String host,String source,String userName,String password) {
	super(MySQL_DRIVER,MYSQL_BRIDGE+ "//"+host+"/"+source,userName,password);	
	}

	public MySqlDataSource(String source,String userName) {
	super(MySQL_DRIVER,MYSQL_BRIDGE+ "//"+"localhost:8889/"+source,userName,"root");
	}
	public MySqlDataSource(String source) {
	
	super(MySQL_DRIVER,MYSQL_BRIDGE+ "//"+"localhost:8889/"+source,"root","root");
	}
	
	public MySqlDataSource(String source,String userName,String password) {
	super(MySQL_DRIVER,MYSQL_BRIDGE+ "//"+"localhost:8889/"+source,userName,password);
	}
		
		
	@Override
	public Connection getConnection() {
		try {
			//1.Chargement du driver
			Class.forName(MySQL_DRIVER);
			//3.La connexion
			Connection db=DriverManager .getConnection(getUrl(),getUser(),getPassword());
			System.out.println("connexion bien �tablie...");
			return db;
		}
		catch (Exception e) {
			System.out.println("Erreur de connexion :"+e.getMessage());
			return null;
		}
		
	}

	public char startDelimiter() {
		return '`';
	}

	public char endDelimiter() {
		return '`';
	}
	
}

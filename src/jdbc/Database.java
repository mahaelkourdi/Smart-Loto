package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.Vector;

import java.sql.DatabaseMetaData;

public class Database {
	private DataSource ds;
	private Connection db;
	private DatabaseMetaData dbm;
	
	public Database(DataSource ds) {
		this.ds=ds;
		db=ds.getConnection();
	}
	
	 public DataSource getDataSource() {
		 return ds;
	 }
	 public void setDataSource(DataSource ds) {
			this.ds = ds;
			db = ds.getConnection();
			try {
				dbm = db.getMetaData();
			} catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}

	 }
	
	/*public void select() {
		String request="SELECT * FROM AUTHORS WHERE Year_Born >0";
		try {
			Statement sql=db.createStatement();
			ResultSet rs= sql.executeQuery(request);
			while(rs.next()) {
				System.out.println(rs.getString(2));	
			}
		}
		catch (Exception e) {
			System.out.println("Erreur :"+e.getMessage());
		}
	}*/
	
	public String[][] excecuteQuery(String request) {
		try {
			Statement sql=db.createStatement();
			ResultSet rs= sql.executeQuery(request);
			ResultSetMetaData rsm=rs.getMetaData();
			int n=rsm.getColumnCount();
			rs.last();
			int m=rs.getRow();
			
			
			String data[][]=new String[m + 1][n];
			for (int i = 0; i < n; i++) {
				data[0][i]=rsm.getColumnName(i+1);
			}
			rs.beforeFirst();
			int row=0;
			while(rs.next()) {
					row++;
					for (int i = 0; i < n; i++) {
						data[row][i]=rs.getString(i+1);
					}
			}
			return data;
		}
		catch (Exception e) {
			System.out.println("Erreur :"+e.getMessage());
			return null;
		}
	}
	
	public String[][] select(String tableName) {
		String request="SELECT * FROM " + tableName;
		return excecuteQuery(request);
	}
	
	public String[][] select(String tableName,String key,Object value) {
		String request="SELECT * FROM " + tableName + " WHERE "+ key +"='" + value + "'";
		return excecuteQuery(request);
	}
	
	
	public String[][] selectLike(String tableName,String key,Object value) {
		String request="SELECT * FROM " + tableName + " WHERE "+ key +" LIKE '%"  + value + "%'";
		return excecuteQuery(request);
	}
	
	public boolean insert(String tableName, HashMap<String, Object>keyValue) {
		Object[] keys = keyValue.keySet().toArray();
		String request="INSERT INTO " + tableName + "(" + keys[0];
		String values = "values( " ; 
		if(keyValue.get(keys[0]) instanceof String) {
			values += "'" +  keyValue.get(keys[0]) + "'";
		}else {
			values += keyValue.get(keys[0]);
		}
		for (int i=1;i<keys.length;i++) {
			request +=  ", " + keys[i];
			if(keyValue.get(keys[i]) instanceof String) {
				values += ",'" +  keyValue.get(keys[i]) + "'";
			}else {
				values += "," + keyValue.get(keys[i]);
			}
			
		}
		request += ")" + values +")";
		System.out.println(request);
		try {
			Statement sql=db.createStatement();
			if(sql.executeUpdate(request) == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur :" +e.getMessage());
			return false;
		}
	}
	
	public boolean insert(String tableName,Object ...row) {
		String request="INSERT INTO " + tableName
				+ " VALUES('" + row[0] + "'";
		for (int i = 1; i < row.length; i++) {
			request=request + ", '"+row[i] +"'";
		}
		request = request + ")";
		System.out.println(request);
		try {
			Statement sql=db.createStatement();
			if(sql.executeUpdate(request) == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur :" +e.getMessage());
			return false;
		}
	}
	
	public boolean delete(String tableName, String key, Object value)
	{
		String req = "DELETE FROM "+ tableName +" WHERE "+key+" = '"+value+"'";
		try {
			Statement sql = db.createStatement();
			
			if(sql.executeUpdate(req) == 1) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			System.out.println("Erreur :" +e.getMessage());
			return false;
		}
	}
	public String delimit(String name) {
		if (name.contains(" ")) {
			name = ds.startDelimiter() + name + ds.endDelimiter();
		}
		return name;
	}
	public String[] getColomnName(String tableName) {
		try {
			Statement stmt = ds.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
			ResultSetMetaData rsmd = rs.getMetaData();
			Vector<String> v = new Vector<>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				v.add(rsmd.getColumnName(i));
			}
			String[] t = new String[v.size()];
			return v.toArray(t);
			
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
	
	public int update(String tableName, Object... row) {
		tableName = delimit(tableName);
		
		try {
			String cols[] = getColomnName(tableName);
			StringBuffer query = new StringBuffer(
					"UPDATE " + tableName + " SET " + delimit(cols[0]) + " = '" + row[0] + "'");
			for (int i = 1; i < row.length; i++) {
				query.append(", " + delimit(cols[i]) + " = '" + row[i] + "'");
			}
			query.append(" WHERE " + delimit(cols[0]) + " = '" + row[0] + "'");
			Statement sql = db.createStatement();
			return sql.executeUpdate(query.toString());
		} catch (Exception e) {
			System.out.println("Erreur : " + tableName + " " + e.getMessage());
			return -1;
		}
	}
}

	
	


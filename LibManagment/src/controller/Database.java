package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String url = "jdbc:sqlite:library.db";
	
	public void initDB() {
		
		String sql = "CREATE TABLE IF NOT EXISTS books (" +
	             "id INTEGER PRIMARY KEY AUTOINCREMENT," +
	             "title TEXT NOT NULL," +
	             "author TEXT," +
	             "isbn TEXT," +
	             "isAvailable Integer)";
		
		try(Connection conn = DriverManager.getConnection(url)){
			if (conn != null) {
				System.out.println("CONNECTED");
				
				Statement stmt = conn.createStatement();
				
				stmt.execute(sql);
				
				System.out.println("Table ready");
				}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	  public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url);
	    }
}

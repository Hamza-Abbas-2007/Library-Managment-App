package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Book;

public class BookDAO {
	
	private Database db = new Database();
	public void addBookDB(Book book) {
		 String insertSql = "INSERT INTO books(title, author, isbn, isAvailable) VALUES(?, ?, ?, ?)";
		 
		 try(Connection conn = db.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(insertSql)){
				   pstmt.setString(1, book.getTitle());
				   pstmt.setString(2, book.getAuthor());
		           pstmt.setString(3, book.getIsbn());
		           pstmt.setBoolean(4, book.isAvailable());
		           pstmt.executeUpdate();

		           System.out.println("Book added: " + book.getTitle());
			 } catch(SQLException e) {
				 System.out.println(e.getMessage());
			 }
		 }
	public Book getLatestBook() {
		String sql = "SELECT * FROM books ORDER BY id DESC LIMIT 1";
		Book book = null;
	    try (Connection conn = db.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ResultSet rs = pstmt.executeQuery()) {

	           if (rs.next()) {
	               book = new Book(
	                   rs.getString("isbn"),
	                   rs.getString("title"),
	                   rs.getString("author"),
	                   rs.getBoolean("isAvailable")
	               );
	           }

	       } catch (SQLException e) {
	           System.out.println(e.getMessage());
	       }

	       return book;
	}
	
	public Book searchByISBN(String isbn) {
		String sql = "SELECT * FROM books WHERE isbn = ?";
		
	    try (Connection conn = db.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {

	           stmt.setString(1, isbn);

	           try (ResultSet rs = stmt.executeQuery()) {
	               if (rs.next()) {
	                   return new Book(rs.getString("isbn"), rs.getString("title"), rs.getString("author"),rs.getBoolean("isAvailable"));
	               }
	           }
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }
	       return null; 
	}
}


package model;

public class Book {
	
	private String isbn;
	private String title;
	private String author;
	private boolean isAvailable;
	
	public Book(String isbn, String title, String author, boolean isAvailable) {
		this.setIsbn(isbn);
		this.setTitle(title);
		this.setAuthor(author);
		this.setAvailable(isAvailable);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}

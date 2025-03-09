package application;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BookRecords {
	
	private int bookId;
	private String author;
	private String title;
	private String category;
	private int publishedYear;
	private String isbn;
	static ArrayList<BookRecords> bookList =new ArrayList<BookRecords>();
	public BookRecords(int bookId, String title, String author, String category, int publishedYear, String isbn) {
		super();
		this.bookId = bookId;
		this.author = author;
		this.title = title;
		this.category = category;
		this.publishedYear = publishedYear;
		this.isbn = isbn;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
	
		this.bookId = bookId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPublishedYear() {
		return publishedYear;
	}
	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return  bookId +","+title+","+ author +","+category+","+ publishedYear +","+  isbn ;
	}
	
	

}

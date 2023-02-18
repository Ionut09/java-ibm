package com.ibm.java._7_collections;

public class Book {
	
	private String title;
	private String isbn;
	private String author;
	
	public Book(String title, String isbn, String author) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public boolean equals(Object o) {    //I can pass here any object from Java
		boolean isArgInstanceOfBook = o instanceof Book;
		if (isArgInstanceOfBook) {
			String title = ((Book) o).getTitle();
			String author = ((Book) o).getAuthor();
			return this.title.equals(title) && this.author.equals(author);
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Book{" +
			       "title='" + title + '\'' +
			       ", isbn='" + isbn + '\'' +
			       ", author='" + author + '\'' +
			       '}';
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
}

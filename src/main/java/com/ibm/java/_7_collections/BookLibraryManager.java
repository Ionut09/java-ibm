package com.ibm.java._7_collections;

public interface BookLibraryManager {
	
	void addBookToLibrary(Book book);
	
	void viewContent();
	
	int searchBook(String title);
	
	void remove(Book book);
	
	void replaceOldBook(Book oldBook, Book newBook);
}

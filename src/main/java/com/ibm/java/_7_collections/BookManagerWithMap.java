package com.ibm.java._7_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
  1. add books to library
  2. view library content
  3. search for Books -> daca e, locatia (prin titlu)
  4. remove Books from library
  5. replace Books in library (with a new one)
 */
public class BookManagerWithMap implements BookLibraryManager {
	
	Map<String, Book> books = new HashMap<>();
	
	//key -> title, value -> Book
	public static void main(String[] args) {
		BookLibraryManager manager = new BookManagerWithMap();
		
		manager.addBookToLibrary(new Book("Moby Dick", "1232312121213", "Herman Melville"));
		manager.addBookToLibrary(new Book("Moby Dick", "1232312121213", "Herm. Melville"));
		manager.addBookToLibrary(new Book("Head First Java", "2781628716286", "Kathy Sierra"));
		manager.addBookToLibrary(new Book("Head First Design Patterns", "2781628712226", "Kathy Sierra"));
		manager.addBookToLibrary(new Book("Thinking in Java", "7628763873682", "Bruce Eckel"));
		manager.addBookToLibrary(new Book("Java 8 in action", "7621234563682", "Mario Fusco"));
		
		manager.viewContent();
		
		int headFirstDesignPatterns = manager.searchBook("Head First Design Patterns");
		System.out.println("headFirstDesignPatterns = " + headFirstDesignPatterns); //1
		
		manager.remove(new Book("Moby Dick", "1232312121213", "Herman Melville"));
		manager.viewContent();
		
		manager.replaceOldBook(new Book("Java 8 in action", "7621234563682", "Mario Fusco"),
							   new Book("Java 11 in action", "7621234563682", "Mario Fusco"));
		manager.viewContent();
	}
	
	@Override
	public void addBookToLibrary(Book book) {
		//overrides old value
		books.put(book.getTitle(), book);
//		books.putIfAbsent(book.getTitle(), book);
	}
	
	@Override
	public void viewContent() {
		int i = 1;
		for (Entry<String, Book> libraryEntry : books.entrySet()) {
			System.out.println("Book nr. -> " + i + ". Title: " + libraryEntry.getKey() + " Book: " + libraryEntry.getValue());
			i++;
		}
	}
	
	@Override
	public int searchBook(String title) {
		boolean titleIsPresent = books.containsKey(title);
		//		if(titleIsPresent){
		//			return 1;
		//		} else{
		//			return 0;
		//		}
		
		//		int result = titleIsPresent ? 1 : 0;
		
		return titleIsPresent ? 1 : 0;
	}
	
	@Override
	public void remove(Book book) {
		//	    books.remove(book.getTitle());
		boolean removed = books.remove(book.getTitle(), book);
		String removalResult = removed ? " was removed " : " was not removed";
		System.out.println("Book: " + book + removalResult);
		
// 		books.compute()
// 		books.computeIfPresent()
// 		books.computeIfAbsent()
	}
	
	@Override
	public void replaceOldBook(Book oldBook, Book newBook) {
//	     books.replace(oldBook.getTitle(), oldBook, newBook);
	     books.replace(oldBook.getTitle(), newBook);
	}
}

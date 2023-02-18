package com.ibm.java._7_collections;

//import java.util.ArrayList; //fully qualified name

import java.util.ArrayList;
import java.util.List;

/*
  1. add books to library
  2. view library content
  3. search for Books -> daca e, locatia (prin titlu)
  4. remove Books from library
  5. replace Books in library (with a new one)
  
 */
public class BookManagerWithList implements BookLibraryManager {
	
	//de instanta (ne-statice) au nevoie de un obiect ca sa existe, doar cu un obiect se pot apela
	//statice ->  nu au nevoie de un obiect ca sa existe
	List<Book> books = new ArrayList<>(); //<> diamond operator
	
	public static void main(String[] args) {
		BookLibraryManager manager = new BookManagerWithList();
		//		books.stream()
/*
		System.out.println(manager.books.size());
		BookLibraryManagement manager2 = new BookLibraryManagement();
		
		System.out.println("manager2 == manager -> " + (manager2 == manager));
		System.out.println("manager2.equals(manager) -> " + manager2.equals(manager));
		
		Book moby = new Book("Moby Dick", "1232312121213", "Herman Melville");
		Book mobyDick = new Book("Moby Dick", "1232312121213", "Herman Melville");
		System.out.println("moby.equals(mobyDick) -> " + moby.equals(mobyDick));
		boolean differentObjectsEquality = mobyDick.equals(manager);
		System.out.println("differentObjectsEquality = " + differentObjectsEquality);
*/
		
		manager.addBookToLibrary(new Book("Moby Dick", "1232312121213", "Herman Melville"));
		manager.addBookToLibrary(new Book("Moby Dick", "1232312121213", "Herman Melville"));
		manager.addBookToLibrary(new Book("Head First Java", "2781628716286", "Kathy Sierra"));
		manager.addBookToLibrary(new Book("Head First Design Patterns", "2781628712226", "Kathy Sierra"));
		manager.addBookToLibrary(new Book("Thinking in Java", "7628763873682", "Bruce Eckel"));
		manager.addBookToLibrary(new Book("Java 8 in action", "7621234563682", "Mario Fusco"));
		manager.viewContent();
		System.out.println("\"Java 8 in action\" is on raft: " + manager.searchBook("Java 8 in action"));
		System.out.println("\"Java 11 in action\" is on raft: " + manager.searchBook("Java 11 in action"));
		
		manager.remove(new Book("Moby Dick", null, null));
		System.out.println("after removal ==> ");
		manager.viewContent();
		
		manager.replaceOldBook(new Book("Java 8 in action", "7621234563682", "Mario Fusco"),
			new Book("Java 11 in action", "2176287127618", "Mario Fusco"));
		
		System.out.println("after replace ==> ");
		manager.viewContent();
		//		books.
	}
	
	@Override
	public void remove(Book book) {
		//      int index = books.indexOf(book);
		//		books.remove(index);//based on index -> remove Book from index 3
		//		books.remove(book);  //based on object
		books.removeIf(bookFromList -> bookFromList.equals(book));
	}
	
	@Override
	public void replaceOldBook(Book oldBook, Book newBook) {
		
		int indexOfOld = books.indexOf(oldBook); //get location of oldBook
		books.set(indexOfOld, newBook);
		//lambda
		
		//		books.replaceAll(book -> {
		//			if (book.equals(oldBook)) {
		//				return newBook;
		//			}
		//			return book;
		//		});
		
	}
	
	public void addBookToLibrary(Book book) {
		books.add(book);
	}
	
	public void viewContent() {
		//		for (Book book : books) {
		//			System.out.println(book);
		//		}
		//
		for (int i = 0; i <= books.size() - 1; i++) {
			System.out.println("Book nr. " + (i + 1) + " -> " + books.get(i));
		}
	}
	
	public int searchBook(String title) {
		//		for (int i = 0; i <= books.size() - 1; i++) {
		//			Book book = books.get(i);
		//			if (book.getTitle().equals(title)) {
		//				return i;
		//			}
		//		}
		//		return -1;
		boolean containsBookWithGivenTitle = books.contains(new Book(title, null, null));
		int indexOfBook = books.indexOf(new Book(title, null, null));
		return indexOfBook + 1;
	}
}

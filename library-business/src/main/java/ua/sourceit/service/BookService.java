package ua.sourceit.service;

import java.util.List;

import ua.sourceit.businessobject.Book;

public interface BookService {

	Book getBook(String id);
	List<Book> getAllBooks();
	Integer deleteBook(String id);
}

package ua.sourceit.service.impl;

import java.util.ArrayList;
import java.util.List;

import ua.sourceit.businessobject.Book;
import ua.sourceit.dataaccess.dao.BookDAO;
import ua.sourceit.dataaccess.dto.BookDTO;
import ua.sourceit.service.BookAdapter;
import ua.sourceit.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	
	public BookServiceImpl() {
		bookDAO = new BookDAO();
	}
	
	public Book getBook(String stringId) {
		// Adapt DataTransferObject(BookDTO) to BusinessObject(Book)
		Integer id = Integer.parseInt(stringId);
		return BookAdapter.from(bookDAO.findById(id));
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		for (BookDTO dto : bookDAO.findAll()) {
			// Adapt DataTransferObject(BookDTO) to BusinessObject(Book)
			books.add(BookAdapter.from(dto));
		}
		return books;
	}
	
	public Integer deleteBook(String stringId){
		Integer id = 0;
				try {
					id = Integer.parseInt(stringId);
					return bookDAO.delete(bookDAO.findById(id));
				} catch(NumberFormatException e){
					e.printStackTrace();
				}
		return id;
	}
}
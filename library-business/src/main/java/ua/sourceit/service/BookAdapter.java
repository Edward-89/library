package ua.sourceit.service;

import ua.sourceit.businessobject.Book;
import ua.sourceit.dataaccess.dto.BookDTO;

public class BookAdapter {

	public static Book from(BookDTO dto) {
		Book book = new Book();
		book.setId(dto.getId());
		book.setAuthor(dto.getAuthor());
		book.setBookName(dto.getBookName());
		return book;
	}
}

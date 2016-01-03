package ua.sourceit.businessobject;

public class Book {

	private Integer id;
	private String author;
	private String bookName;
	
	public Book() {}
	
	public Book(Integer id, String author, String bookName) {
		setId(id); setAuthor(author); setBookName(bookName);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}

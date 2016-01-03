<%@ page import="ua.sourceit.service.BookService,
				ua.sourceit.service.impl.BookServiceImpl,
				ua.sourceit.html.BookRenderer,
				ua.sourceit.businessobject.Book" %>

<%! private BookService service = new BookServiceImpl(); %>

<html>
<body>
<h1>Hello librarians!</h1>
<h2>The list of books is available below:</h2>
<% java.util.List<Book> books = service.getAllBooks();
	/**new java.util.ArrayList<Book>();
	books.add(new Book(1,"Mark Twain","The Adventures of Tom Sawyer"));
	books.add(new Book(2,"Lewis Carroll","Alice's Adventures in Wonderland"));
	books.add(new Book(3,"Stephenie Meyer","Twilight"));*/
%>
<% for (Book book : books) { %>
<%= BookRenderer.toHtml(book) %><br>
<% } %>


</body>
</html>

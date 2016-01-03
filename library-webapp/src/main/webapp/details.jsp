<%@ page import="ua.sourceit.service.BookService,
				ua.sourceit.service.impl.BookServiceImpl,
				ua.sourceit.html.BookRenderer,
				ua.sourceit.businessobject.Book" %>

<%! private BookService service = new BookServiceImpl(); %>

<html>
<body>
<h1>Hello librarians!</h1>

<h2>The book you have chosen is</h2>

<% Book book = service.getBook(request.getParameter("bookid"));
	//new Book(1,"Mark Twain","The Adventures of Tom Sawyer");
%>
<%= BookRenderer.toDetailedHtml(book) %><br>
<h2><a href="javascript:history.back()">Back</a></h2>
</body>
</html>

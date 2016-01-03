package ua.sourceit.html;

import ua.sourceit.businessobject.Book;

public class BookRenderer {

	public static String toHtml(Book book) {
		StringBuilder html = new StringBuilder("<div>");
		html.append("<table>").append("<tr>").append("<td>");
		html.append("<h2>").append(book.getId()).append("</h2>");
		html.append("</td>").append("<td>");
		html.append("<h4><a href=\"details.jsp?bookid="+book.getId()+"\">")
			.append(book.getBookName()).append("</a></h4>");
		html.append("<h5>").append(book.getAuthor()).append("</h5>");
		html.append("</td>").append("</tr>").append("</table>");
		return html.append("</div>").toString();
	}
	
	public static String toDetailedHtml(Book book) { return toHtml(book); }
}

package ua.sourceit.dataaccess.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.sourceit.dataaccess.BookDBConnection;
import ua.sourceit.dataaccess.dto.BookDTO;

public class BookDAO implements GenericDAO<Integer, BookDTO>{
	
	private static final String FIND_ALL_SQL	= "SELECT * FROM books";
	private static final String FIND_BY_ID_SQL	= "SELECT * FROM books WHERE id = ?";
	private static final String SAVE_SQL 		= "INSERT INTO books (id, author, book_name) VALUES (?, ?, ?)";
	private static final String UPDATE_SQL 		= "UPDATE books SET id=?, author=?, book_name=?";
	private static final String DELETE_SQL 		= "DELETE FROM books WHERE id=? AND author=? AND book_name=?";
	
	@Override
	public BookDTO findById(Integer id) {
		
		Connection connection = null; 
		BookDTO result = null;
		try {
			connection = BookDBConnection.getInstance();
			// try-with-resources - will be closed automatically
			try (PreparedStatement st = connection.prepareStatement(FIND_BY_ID_SQL)) {
				st.setInt(1, id);
				
				// try-with-resources - will be closed automatically
				try (ResultSet rs = st.executeQuery()) {
					if (rs.next()) {
						result = getBookDtoFromResultSet(rs);
					}
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return result;
	}
	
	
	private BookDTO getBookDtoFromResultSet(ResultSet rs) throws SQLException {
		BookDTO dto = new BookDTO();
		dto.setId(rs.getInt("id"));
		dto.setAuthor(rs.getString("author"));
		dto.setBookName(rs.getString("book_name"));
		return dto;
	}

	@Override
	public List<BookDTO> findAll() {
		Connection connection = null; 
		List<BookDTO> list = new ArrayList<BookDTO>();
		try {
			connection = BookDBConnection.getInstance();
			try(Statement st = connection.createStatement()){
				try(ResultSet rs = st.executeQuery(FIND_ALL_SQL)){
					while(rs.next()) list.add(getBookDtoFromResultSet(rs));
				}
			} 
		} catch(IOException e){
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public Integer save(BookDTO value) {
		return getIntFromExecuteUpdate(SAVE_SQL, value);
	}
	
	@Override
	public Integer update(BookDTO value) {
		return getIntFromExecuteUpdate(UPDATE_SQL, value);
	}
	
	@Override
	public Integer delete(BookDTO value) {
		return getIntFromExecuteUpdate(DELETE_SQL, value);
	}
	
	//Optimal variant for INSERT, UPDATE and DELETE
	private Integer getIntFromExecuteUpdate(String sql, BookDTO value){
		Connection connection = null; 
		try {
			connection = BookDBConnection.getInstance();
			try(PreparedStatement st = connection.prepareStatement(sql)){
				st.setInt(1, value.getId());
				st.setString(2, value.getAuthor());
				st.setString(3, value.getBookName());
				return st.executeUpdate();
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}
}
